package tfip.ssf.Workshop13.model;

import java.io.Serializable;

import tfip.ssf.Workshop13.helper.helper;

public class contact implements Serializable {
    private String name;
    private String email;
    private int phone;
    private String hexID;

    public contact(){
        this.hexID = helper.generateID(8);
    }

    public contact(String name,String email,int phone){
        this.hexID = helper.generateID(8);
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    

    /**
     * @return String return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the phone
     */
    public int getPhone() {
        return this.phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(Integer phone) {
        this.phone = phone;
    }


    /**
     * @return String return the hexID
     */
    public String getHexID() {
        return this.hexID;
    }

    /**
     * @param hexID the hexID to set
     */
    public void setHexID(String hexID) {
        this.hexID = hexID;
    }

public static void main(String[] args) {
    contact contact = new contact();
    String ID = contact.getHexID();
    System.out.println(ID);
}

}

