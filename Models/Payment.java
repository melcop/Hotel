package Models;

import java.util.ArrayList;

/**
 *
 * @author Charlie
 */
public class Payment {
    private String fName;
    private String lName;
    private boolean breakfast;
    private boolean lunch;
    private boolean fitnessSpa;
    private int numberOfRooms;
    private int priceOfRoom;
    private int totalPrice;

    public Payment(String fName, String lName, boolean breakfast, boolean lunch, boolean fitnessSpa, int numberOfRooms, int priceOfRoom, int totalPrice) {
        this.fName = fName;
        this.lName = lName;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.fitnessSpa = fitnessSpa;
        this.numberOfRooms = numberOfRooms;
        this.priceOfRoom = priceOfRoom;
        this.totalPrice = totalPrice;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }

    public boolean isLunch() {
        return lunch;
    }

    public void setLunch(boolean lunch) {
        this.lunch = lunch;
    }

    public boolean isFitnessSpa() {
        return fitnessSpa;
    }

    public void setFitnessSpa(boolean fitnessSpa) {
        this.fitnessSpa = fitnessSpa;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getPriceOfRoom() {
        return priceOfRoom;
    }

    public void setPriceOFRoom(int priceOfRoom) {
        this.priceOfRoom = priceOfRoom;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }


    
}
