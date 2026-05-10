import java.util.ArrayList;

public class Allcages {
    private ArrayList<Cage> cages;

    public Allcages() {
        cages = new ArrayList<Cage>();
    }

    public void add(Cage cage) {
        cages.add(cage);
    }

    public Cage get(int number) {
        if (number >= 0 && number < cages.size()) {
            return cages.get(number);
        }
        return null;
    }

    public int size(){
        return cages.size();
    }
}