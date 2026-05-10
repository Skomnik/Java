import java.util.ArrayList;

public class Cage {
    private int cageId;
    private int capacity;
    private ArrayList<Animal> animals;
    private boolean havekeeper;

    public Cage(int cageId, int capacity) {
        setCageId(cageId);
        setCapacity(capacity);
        this.animals = new ArrayList<>();
        setHavekeeper(false);
    }

    public boolean isCagefree(){
        if (capacity == getAnimalCount()) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean isHavekeeper() {
        return havekeeper;
    }

    public void setHavekeeper(boolean havekeeper) {
        this.havekeeper = havekeeper;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCageId(int cageId) {
        this.cageId = cageId;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public void addAnimal(Animal animal) {
        if (capacity > animals.size()) {
        animals.add(animal);
        }
        else{
            System.out.println("no space");
        }
    }

    public int getAnimalCount() {
        return animals.size();
    }

    public int getCageId() {
        return cageId;
    }

    @Override
    public String toString() {
        return "Cage{" +
                "cageId=" + cageId +
                ", capacity=" + capacity +
                ", animals=" + animals +
                '}';
    }

    public void displayAnimals() {
        System.out.println("Cage " + cageId + " contains:");
        for (Animal a : animals) {
            System.out.println(" - " + a.toString());
        }



    }
}
