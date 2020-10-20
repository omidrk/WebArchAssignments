package it.unitn.disi.jadidi.delivery2;


/**
 *
 * @author Dimo
 */

// This class is used to pars the result of the query execution
public class User {
    private int ID;
    public String USERNAME;
    private String PASSWORD;
    
    public void User(){}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }
    
 
    
}
