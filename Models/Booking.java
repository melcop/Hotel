package Models;

import java.sql.Date;

/**
 *
 * @author Charlie
 */
public class Booking {
    Date dateFrom;
    Date dateTo;
    int customerID;
    Room roomNr;

    public Booking(Date dateFrom, Date dateTo, int customerID, Room roomNr) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.customerID = customerID;
        this.roomNr = roomNr;
    }

  
    
}
