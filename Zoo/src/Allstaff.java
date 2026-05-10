import java.util.ArrayList;

public class Allstaff {
    private ArrayList<Keeper> staff;

    public Allstaff() {
        staff = new ArrayList<Keeper>();
    }

    public void add(Keeper keeper) {
        staff.add(keeper);
    }

    public void delete(int number){
        staff.remove(number);
    }

    public Keeper get(int number){
        return staff.get(number);
    }

    public int size(){
        return staff.size();
    }


}
