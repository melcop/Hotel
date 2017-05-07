package Database;

import Models.Payment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Charlie
 */
public class PaymentConnection {

    private final Connection connection = DBconnection.createConnection();

    /**
     * this method handle data from PaymentGUI to DB
     * @param payment
     * @throws SQLException
     */
    public void createPayment(Payment payment) throws SQLException {
        
        String sql = "INSERT INTO payment (fName, lName, breakfast, lunch, fitnessSpa, numberOfRooms, priceOfRoom, totalPrice) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, payment.getfName());
        preparedStatement.setString(2, payment.getlName());
        preparedStatement.setBoolean(3, payment.isBreakfast());
        preparedStatement.setBoolean(4, payment.isLunch());
        preparedStatement.setBoolean(5, payment.isFitnessSpa());
        preparedStatement.setInt(6, payment.getNumberOfRooms());
        preparedStatement.setInt(7, payment.getPriceOfRoom());
        preparedStatement.setInt(8, payment.getTotalPrice());
    
        preparedStatement.executeUpdate();

  
        preparedStatement.close();
        
    }
}
