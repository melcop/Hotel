package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.Manager;
import Models.User;

/**
 *
 * @author Charlie
 */
public class ManagerConnection  {

    private final Connection connection = DBconnection.createConnection();

    /**
     * gets list of Manager
     * @return ManagerList
     */
    public List getManagerList() {

        List<Manager> list = new ArrayList();
        Statement statement;
        try {
            statement = connection.createStatement();

            String sql = "SELECT fName, lName, managerID FROM manager";

            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {

                Manager manager = new Manager(
                        null, result.getString("fName"), result.getString("lName"), null, null, null, null, null, result.getInt("managerID"), null);
                list.add(manager);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     * gets User
     * @param username
     * @param password
     * @return User
     */
    //Forstår ikke helt den kode
    public User getUser(String username, String password) {
        try {
            String sql = "SELECT * FROM login WHERE username = ? AND password = MD5(?)";
            PreparedStatement preStatement = connection.prepareStatement(sql);
            preStatement.setString(1, username);
            preStatement.setString(2, password);
            ResultSet result = preStatement.executeQuery();
            // first() : Moves the cursor to the first row in this ResultSet object.
            if (result.first()) {
                String passwordUser = result.getString("password");
                String usernameUser = result.getString("username");
                int userID = result.getInt("userID");

                User user = new User(userID, usernameUser, passwordUser);
                return user;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     * createManager
     * @param manager
     * @throws SQLException
     */
    public void createInstructor(Manager manager) throws SQLException
    {
        String saveUser="INSERT INTO login(username, password) VALUES( ?, MD5(?))";
                
        PreparedStatement preparedStatement = connection.prepareStatement(saveUser);
        preparedStatement.setString(1, manager.getUser().getUsername());
        preparedStatement.setString(2, manager.getUser().getPassword());
        preparedStatement.executeUpdate();
     
        int userID = getNewestUserID();
    
         String sql = "INSERT INTO manager (CPR, fName, lName, streetName, streetnumber, email,"
                + " phoneNumber, FK_postalCode, fk_userID) VALUES (?,?,?,?,?,?,?,?,?)";

         preparedStatement = connection.prepareStatement(sql);
        
        preparedStatement.setString(1, manager.getfName());
        preparedStatement.setString(2, manager.getlName());
        preparedStatement.setString(3, manager.getAddress());
        preparedStatement.setString(4, manager.getPostalNR());
        preparedStatement.setString(5, manager.getCity());
        preparedStatement.setString(6, manager.getCountry());
        preparedStatement.setString(7, manager.getMail());
        preparedStatement.setInt(9, userID);
    
        preparedStatement.executeUpdate();
    }
    
    /**
     * editManager
     * @param manager
     */
    public void editInstructor(Manager manager)
    {
           String sql = "UPDATE instructor SET"
                    + " CPR = ?,"
                    + " fName = ?,"
                    + "lName = ?,"
                    + "streetName = ?,"
                    + "streetNumber = ?,"
                    + "email = ?,"
                    + "phonenumber= ?,"
                    + "FK_postalCode=?"
                   + "WHERE instructorID = " + manager.getManagerID();

            
           
            try {
            PreparedStatement preparedstamentEditManager = connection.prepareStatement(sql);
          
             preparedstamentEditManager.setString(1, manager.getfName());
             preparedstamentEditManager.setString(2, manager.getlName());
             preparedstamentEditManager.setString(3, manager.getAddress());
             preparedstamentEditManager.setString(4, manager.getPostalNR());
             preparedstamentEditManager.setString(5, manager.getCity());
             preparedstamentEditManager.setString(6, manager.getCountry());
             preparedstamentEditManager.setString(7, manager.getMail());
    
            preparedstamentEditManager.executeUpdate();
            
            String editUser = "UPDATE login SET "
                    + "username = ?,"
                    + "password = MD5(?)"
                    + "WHERE userID = " + manager.getUser().getUserID() ;
            
            preparedstamentEditManager = connection.prepareStatement(editUser);
            
            preparedstamentEditManager.setString(1, manager.getUser().getUsername());
            preparedstamentEditManager.setString(2, manager.getUser().getPassword());
            
            preparedstamentEditManager.executeUpdate();
            
            } catch (SQLException ex) {
                System.out.println("Doesn't work, check sql query!");;
            }
    
    }

    /**
     * search for searchInstructorID
     * @param managerID
     * @return
     * @throws SQLException
     */
    public Manager searchIManagerID(int managerID) throws SQLException
    {
        Manager searchedManager=null;
        String city=null;
        Manager manager=null;
        User user=null;
        
        Statement statement = connection.createStatement();
        //get city from DB
        String sqlGetCity = "SELECT postalCode, cityname, municipal FROM city" 
                        + " INNER JOIN instructor"
                        + " ON postalCode = fk_postalCode "
                        + " WHERE instructorID = " + managerID;
        
        ResultSet cityResult = statement.executeQuery(sqlGetCity);
        
      
         
        String sqlGetUser= "SELECT userID, username,password FROM login"
                + " INNER JOIN instructor"
                + " ON userid = fk_userid"
                + " WHERE instructorID=" + managerID;
        
        ResultSet userResult= statement.executeQuery(sqlGetUser);
        while(userResult.next())
        {
            user= new User(userResult.getInt("userID"),userResult.getString("username"),userResult.getString("password"));
        }
        
        String sqlInst = "SELECT managerID, fName, lName, CPR, streetName, streetNumber, email, phonenumber,"
                + " phoneNumber, FK_postalCode, fk_userID"
                + " FROM manager WHERE managerID = '" + managerID + "'";
        
        ResultSet managerResult = statement.executeQuery(sqlInst);
        
        while(managerResult.next()) {
            searchedManager = new Manager(managerResult.getString("fName"), managerResult.getString("lName")
            , managerResult.getString("address"), managerResult.getString("postalNR"), managerResult.getString("city")
            , managerResult.getString("country"), managerResult.getString("TLF"), managerResult.getString("mail"), managerResult.getInt("managerID"),user); 
                    
        }
        return searchedManager;
    }
   
    /**
     * remove Manager
     * @param managerID
     * @throws SQLException
     */
    public void removeManager(int managerID) throws SQLException {
        
        String remove = "DELETE FROM Manager WHERE managerID=?";
        PreparedStatement preStatement=connection.prepareStatement(remove);
        preStatement.setInt(1, managerID);
        preStatement.executeUpdate();
    }
    
    /**
     * gets the newest ManagerID
     * @return int of the newest ManagerID
     */
    public int getNewestManagerID() {
    
        int managerID = 0;
        
        String sqluserID = "SELECT MAX(managerID) FROM `manager`";
        Statement statement;
        try {
            statement = connection.createStatement();

        ResultSet userIDResult = statement.executeQuery(sqluserID);
        
        while(userIDResult.next()) {
            
            managerID = userIDResult.getInt("MAX(managerID)");
        }
        } catch (SQLException ex) {
            Logger.getLogger(ManagerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return managerID;
    }
    
    /**
     * gets the newest userID
     * @return int of the newest userID
     */
    public int getNewestUserID() {
    
        int userID = 0;
        
        String sqluserID = "SELECT MAX(userID) FROM `login`";
        Statement statement;
        try {
            statement = connection.createStatement();

        ResultSet userIDResult = statement.executeQuery(sqluserID);
        
        while(userIDResult.next()) {
            
            userID = userIDResult.getInt("MAX(userID)");
        }
        } catch (SQLException ex) {
            Logger.getLogger(ManagerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userID;
    }

}
