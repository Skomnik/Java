import java.util.ArrayList;

public class Allanimals {
    private ArrayList<Animal> Animals;

    public Allanimals() {
        Animals = new ArrayList<Animal>();
    }

    public void add(Animal animal) {
        Animals.add(animal);
    }

    public void delete(int number) throws InputValidationException {
        if (number >= 0 && number < Animals.size()) {
            Animals.remove(number);
        }
        else {
            throw new InputValidationException("wrong cage number");
        }
    }

    public Animal get(int number){
        return Animals.get(number);
    }

    public int size(){
        return Animals.size();
    }
}