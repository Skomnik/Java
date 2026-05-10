public class HeadKeeper extends Employee{
    private String firstName;
    private String surName;
    private String contactNumber;
    private String address;
    private String position;

    public HeadKeeper(String firstName, String surName, String contactNumber, String address, String position) {
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

    public void assignKeeper(Keeper keeper, Cage cage){
        keeper.assignCage(cage);
    }

    public void assignAnimal(Animal animal, Cage cage){
        cage.addAnimal(animal);
    }
}
