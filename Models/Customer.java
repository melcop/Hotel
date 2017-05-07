package Models;

import java.util.ArrayList;

/**
 *
 * @author Charlie
 */
public class Customer extends Person {
        
        private int customerID;
	


   public Customer(String fName, String lName,
			String address, String postalNR, String city,
			String country, String TLF, String mail) {
		
		super(fName, lName, address, postalNR, city, country, TLF, mail);
		
             	
	}
   
   public Customer(int customerID, String fName, String lName,
			String address, String postalNR, String city,
			String country, String TLF, String mail){
                        
                        super(fName, lName, address, postalNR, city, country, TLF, mail);
                        this.customerID=customerID;
   }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

   
}
