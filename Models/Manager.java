package Models;

/**
 * @author Charlie
 *
 */

public class Manager extends Person {

        private int managerID;
	private User user;
        
    /**
     * Constructor of Instructor 
     * @param fName
     * @param lName
     * @param address
     * @param postalNR
     * @param city
     * @param country
     * @param TLF
     * @param mail
     * @param managerID
     * @param user
     */
    public Manager(String fName, String lName,
			String address, String postalNR, String city,
			String country, String TLF, String mail, int managerID, User user) {
		
		super(fName, lName, address, postalNR, city, country, TLF, mail);
		
                this.managerID = managerID;
                this.user = user;
	}
    
  
    /**
     * gets User
     * @return Object User
     */
    public User getUser() {
            return user;
        }

    /**
     * sets User
     * @param user
     */
    public void setUser(User user) {
            this.user = user;
        }
        
    /**
     * gets ID of Manager
     * @return int of ManagerID
     */
    public int getManagerID() {
            return managerID;
        }

    /**
     * sets ManagerID
     * @param managerID
     */
    public void setManagerID(int managerID) {
            this.managerID = managerID;
        }
        
        public String toString() {
            return super.getfName() + " " + super.getlName();
        }
        
    /**
     * This method will return a Manager first and last name with the names first letter en upperCase
     * @return String
     */
    public String print() {
        
            return "ID: " + managerID + " " + super.getfName().substring(0, 1).toUpperCase() + super.getfName().substring(1, super.getfName().length()) + 
                    " " + super.getlName().substring(0, 1).toUpperCase() + super.getlName().substring(1, super.getlName().length());
        }
}
