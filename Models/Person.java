package Models;

/**
 *
 * @author Charlie
 */
public class Person {
	private String fName;
	private String lName;
	private String address;
	private String postalNR;
	private String city;
	private String country;
        private String TLF;
        private String mail;
       
	
    /**
     * Constructor of Person Object
     * @param fName
     * @param lName
     * @param address
     * @param postalNR
     * @param city
     * @param country
     * @param TLF
     * @param mail
     */
    public Person(String fName, String lName, String address, String postalNR, String city, String country, String TLF, String mail) {
		
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.postalNR = postalNR;
		this.city = city;
		this.country = country;
		this.TLF = TLF;
                this.mail=mail;
                
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalNR() {
        return postalNR;
    }

    public void setPostalNR(String postalNR) {
        this.postalNR = postalNR;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTLF() {
        return TLF;
    }

    public void setTLF(String TLF) {
        this.TLF = TLF;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
 
}