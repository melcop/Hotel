package Database;

import Models.Room;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Charlie
 */
public class RoomConnection {
    
    private final Connection connection = DBconnection.createConnection();
    
    public Room searchRoomID(int roomNr) throws SQLException{
       
       Room room=null;
       Statement statement = connection.createStatement();
    
        String sqlRoom = "SELECT  roomPrice"
                + " FROM room WHERE roomNr = '" + roomNr + "'";
        
        ResultSet roomResult = statement.executeQuery(sqlRoom);
        
        while(roomResult.next()) {
            room = new Room(null, roomResult.getInt("roomPrice"),null);            
        }
        return room;
    }
}
