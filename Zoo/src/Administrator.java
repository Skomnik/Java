public class Administrator extends Employee{
    private String firstName;
    private String surName;
    private String contactNumber;
    private String address;
    private String position;

    public Administrator(String firstName, String surName, String contactNumber, String address, String position) {
        setFirstName(firstName);
        setSurName(surName);
        setContactNumber(contactNumber);
        setAddress(address);
        setPosition(position);
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getSurName() {
        return surName;
    }

    @Override
    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public String getContactNumber() {
        return contactNumber;
    }

    @Override
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public void setPosition(String position) {
        this.position = position;
    }

    public Animal createAnimal(int animalid, String name, String type, String category, int animaldob, int animaldoa, String sex) throws InputValidationException {

        return new Animal(animalid, name, type, category, animaldob, animaldoa, sex);
    }

    public Keeper createKeeper(int keeperid, String firstName, String surName, String address, String contactNumber, String position) throws InputValidationException {
        return new Keeper(keeperid,firstName,surName,address,contactNumber,position,null);

    }
}
