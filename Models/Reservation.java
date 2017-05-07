package Models;

/**
 *
 * @author Charlie
 */
public class Reservation {
    private int customerID;
    private int numberOfRooms;
    private int totalPrice;

    public Reservation(int customerID, int numberOfRooms, int totalPrice) {
        this.customerID = customerID;
        this.numberOfRooms = numberOfRooms;
        this.totalPrice = totalPrice;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Reservation{" + "customerID=" + customerID + ", numberOfRooms=" + numberOfRooms + ", totalPrice=" + totalPrice + '}';
    }
    
    
   
}
