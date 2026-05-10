
public abstract class Employee {
    private String firstName;
    private String surName;
    private String contactNumber;
    private String address;
    private String position;


    public abstract String getFirstName();
    public abstract void setFirstName(String firstName) throws InputValidationException;
    public abstract String getSurName();
    public abstract void setSurName(String surName) throws InputValidationException;
    public abstract String getAddress() ;
    public abstract void setAddress(String address) throws InputValidationException;
    public abstract String getContactNumber();
    public abstract void setContactNumber(String contactNumber) throws InputValidationException;
    public abstract String getPosition();
    public abstract void setPosition(String position) throws InputValidationException;
}