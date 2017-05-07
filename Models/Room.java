package Models;

/**
 *
 * @author Charlie
 */
public class Room {
    private String roomNr;
    private int roomPrice;
    private String roomType;

    public Room(String roomNr, int roomPrice, String roomType) {
        this.roomNr = roomNr;
        this.roomPrice = roomPrice;
        this.roomType = roomType;
    }

    public String getRoomNr() {
        return roomNr;
    }

    public void setRoomNr(String roomNr) {
        this.roomNr = roomNr;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "Room{" + "" + "" + roomPrice + "" + '}';
    }
    
    
}
