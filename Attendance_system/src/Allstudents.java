import java.util.ArrayList;

public class Allstudents {


    @Override
    public String toString() {
        return "Allstudents{" +
                "students=" + students +
                '}';
    }

    public ArrayList<Student> students;

    public Allstudents() {
        students = new ArrayList<Student>();
    }

    public void add(Student student) {
        students.add(student);
    }

    public void sortstud(){
        boolean swap = true;
        while (swap){
            swap = false;
            for (int i = 0; i <students.size()-1 ; i++) {
                if (students.get(i).getSsname().compareTo(students.get(i+1).getSsname())>0) {
                    Student temp = students.get(i+1);
                    students.set(i+1,students.get(i));
                    students.set(i,temp);
                    swap = true;
                }
            }
        }
    }


}
