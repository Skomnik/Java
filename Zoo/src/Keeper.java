import java.util.ArrayList;

public class Keeper extends Employee {

    private int keeperId;
    private String firstName;
    private String surName;
    private String address;
    private String contactNumber;
    private String position;
    private ArrayList<Cage> allocatedCages;

    public Keeper(int keeperId, String firstName, String surName, String address, String contactNumber, String position, Cage cage)
            throws InputValidationException {

        setKeeperId(keeperId);
        setFirstName(firstName);
        setSurName(surName);
        setAddress(address);
        setContactNumber(contactNumber);
        setPosition(position);

        this.allocatedCages = new ArrayList<>();
        if (cage != null) {
            assignCage(cage);
        }
    }


    public int getKeeperId() {
        return keeperId;
    }

    public void setKeeperId(int keeperId) throws InputValidationException {
        if (keeperId > 0 && keeperId <= 9999) {
            this.keeperId = keeperId;
        } else {
            throw new InputValidationException("Keeper ID must be between 1 and 9999");
        }
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws InputValidationException {
        if (firstName != null && firstName.matches("(\\p{ASCII}){2,25}")) {
            this.firstName = firstName;
        } else {
            throw new InputValidationException("Invalid first name");
        }
    }


    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) throws InputValidationException {
        if (surName != null && surName.matches("(\\p{ASCII}){2,25}")) {
            this.surName = surName;
        } else {
            throw new InputValidationException("Invalid surname");
        }
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws InputValidationException {
        if (address != null && address.matches("(\\p{ASCII}){2,25}")) {
            this.address = address;
        } else {
            throw new InputValidationException("Invalid address");
        }
    }


    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) throws InputValidationException {
        if (contactNumber != null && contactNumber.matches("(\\p{ASCII}){2,25}")) {
            this.contactNumber = contactNumber;
        } else {
            throw new InputValidationException("Invalid contact number");
        }
    }


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) throws InputValidationException {
        if (position != null && position.matches("[A-Za-z]{4,20}")) {
            this.position = position;
        } else {
            throw new InputValidationException("Invalid position");
        }
    }


    public void assignCage(Cage cage) {
        if (allocatedCages.size() < 4) {
            allocatedCages.add(cage);
            System.out.println("Cage " + cage.getCageId() +
                    " assigned to Keeper " + firstName);
        } else {
            System.out.println("Error: Keeper " + firstName +
                    " already has 4 cages.");
        }
    }

    public boolean isAvailable() {
        return allocatedCages.size() < 4;
    }

    @Override
    public String toString() {
        return "Keeper{" +
                "keeperId=" + keeperId +
                ", firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", position='" + position + '\'' +
                ", allocatedCages=" + allocatedCages +
                '}';
    }
}
