import java.util.ArrayList;
import java.util.Date;

public class Journal {
    private Course course;
    private String date;
    public ArrayList<Student> studentArrayList;

    public Journal(Course course, String date) {
        setCourse(course);
        setDate(date);
        studentArrayList = new ArrayList<>();

    }

    public void sortstud(){
        boolean swap = true;
        while (swap){
            swap = false;
            for (int i = 0; i <studentArrayList.size()-1 ; i++) {
                if (studentArrayList.get(i).getSsname().compareTo(studentArrayList.get(i+1).getSsname())>0) {
                    Student temp = studentArrayList.get(i+1);
                    studentArrayList.set(i+1,studentArrayList.get(i));
                    studentArrayList.set(i,temp);
                    swap = true;
                }
            }
        }
    }

    public void addAttendance(Student student) {
        studentArrayList.add(student);
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
