package Database;

import Models.Reservation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Charlie
 */
public class ReservationConnection {
    private final Connection connection = DBconnection.createConnection();
    
    
    /**
     * create a reservation
     * @param reservation
     * @throws SQLException
     */
    public void createReservation(Reservation reservation) throws SQLException {
        
      //  int reservation = 0;
        String sql = "INSERT INTO reservation (customerID, numberOfRooms, totalPrice)  VALUES (?,?,?)"; 
                

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        
        preparedStatement.setInt(1, reservation.getCustomerID());
        preparedStatement.setInt(2, reservation.getNumberOfRooms());
        preparedStatement.setInt(3, reservation.getTotalPrice());
    
   
        //insert customer
        preparedStatement.executeUpdate();
        
        
    }
    
    public Reservation getNewestReservation()
    {
        String sqlReservation = "SELECT * FROM `reservation` WHERE reservationid=(SELECT MAX(reservationid) FROM `reservation`)";
        Reservation reservation=null;
        Statement statement;
        try {
            statement = connection.createStatement();
        
        ResultSet reservationIDResult = statement.executeQuery(sqlReservation);
        
        while(reservationIDResult.next()) {
            
            reservation = new Reservation(reservationIDResult.getInt("customerID"),reservationIDResult.getInt("numberOfRooms"),reservationIDResult.getInt("totalPrice"));
            
        }
        statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return reservation;
    }
  
}
