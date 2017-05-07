package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.Customer;
import Models.Perk;

/**
 *
 * @author Charlie
 */
public class CustomerConnection {
        
	
    private final Connection connection = DBconnection.createConnection();

    /**
     * gets newest CustomerID
     * @return int of newest MemberID
     */
    public int getNewestCustomerID()
    {
        String sqlCustomerID = "SELECT MAX(customerID) FROM `customer`";
        int customerID = -1;
        Statement statement;
        try {
            statement = connection.createStatement();
        
        ResultSet customerIDResult = statement.executeQuery(sqlCustomerID);
        
        while(customerIDResult.next()) {
            
            customerID = customerIDResult.getInt("MAX(customerID)");
            
        }
        statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return customerID;
    }
    
    /**
     * create a customer
     * @param customer
     * @throws SQLException
     */
    public void createCustomer(Customer customer) throws SQLException {
        
        int customerID = 0;
        String sql = "INSERT INTO customer (fName, lName, address, postalNR, city,"
                + " country, TLF, mail)  VALUES (?,?,?,?,?,?,?,?)"; 
                

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        
        preparedStatement.setString(1, customer.getfName());
        preparedStatement.setString(2, customer.getlName());
        preparedStatement.setString(3, customer.getAddress());
        preparedStatement.setString(4, customer.getPostalNR());
        preparedStatement.setString(5, customer.getCity());
        preparedStatement.setString(6, customer.getCountry());
        preparedStatement.setString(7, customer.getTLF());
        preparedStatement.setString(8, customer.getMail());
   
        //insert customer
        preparedStatement.executeUpdate();
        
        //get memberid
        
        customerID = getNewestCustomerID(); 
        
        
    }
    
    /**
     * serach for customerID
     * @param customerID
     * @return Customer
     */
    public Customer searchCustomerID(int customerID) {
        Customer searchedCustomer = null;
        
        
        try {
        Statement statement = connection.createStatement();
        //get city from DB
   
        

        String sql = "SELECT customerID, fName, lName, address, postalNR, city, country, TLF, mail"
                + " FROM customer WHERE customerID = '" + customerID + "'";
        
        ResultSet customerResult = statement.executeQuery(sql);
        
        while(customerResult.next()) {
            searchedCustomer = new Customer(customerResult.getInt("customerID"),customerResult.getString("fName"), customerResult.getString("lName")
            , customerResult.getString("address"), customerResult.getString("postalNR"), customerResult.getString("city")
            , customerResult.getString("country"),customerResult.getString("TLF"),customerResult.getString("mail")); 
                    

            
        }
        statement.close();
    
        }catch(Exception e) {
            System.err.println(e);
            
        }
        return searchedCustomer;
    }

    
    /**
     * edit a customer
     * @param customer
     */
    public void editCustomer(Customer customer) {
    
                   String sql = "UPDATE member SET"
                    + " fName = ?,"
                    + "lName = ?,"
                    + "address = ?,"
                    + "postalNR= ?,"
                    + "city = ?,"
                    + "country= ?,"
                    + "TLF= ?, "
                    + "mail = ?,"
                   + "WHERE customerID = " + customer.getCustomerID();
                   
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
          
            preparedStatement.setString(1, customer.getfName());
            preparedStatement.setString(2, customer.getlName());
            preparedStatement.setString(3, customer.getAddress());
            preparedStatement.setString(4, customer.getPostalNR());
            preparedStatement.setString(5, customer.getCity());
            preparedStatement.setString(6, customer.getCountry());
            preparedStatement.setString(7, customer.getTLF());
            preparedStatement.setString(8, customer.getMail());
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
                   
    }
    
       public Perk getPerk(int id) {
        Perk perk = null;
        try {
            String sql = "SELECT * FROM perk WHERE perkID='"+id+"'";
            Statement statement;
            statement = connection.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            
            
            while(rs.next()) {
                perk = new Perk(rs.getString("perkname"), rs.getInt("perkprice"), rs.getInt("perkid"));
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return perk;
    }
    
    /**
     * This method gets customerID by CPR
     * @param cpr
     * @return in of customerID
     */
    public int CustomerExist(String cpr) {
    
        String sql = "SELECT customerID FROM customer WHERE cpr = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, cpr);
            
            ResultSet result = preparedStatement.executeQuery();
            
            if(result.first()) {
                return result.getInt("customerid");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return -1;
    } 
}
