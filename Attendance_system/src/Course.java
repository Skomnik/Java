import java.util.ArrayList;

public class Course {
    private String title;
    private Lecturer lecturer;
    private int sqf;
    public ArrayList<Student> coursestudents;
    public ArrayList<Journal> coursejournals;


    private Journal attendance;

    public Course(String title, int sqf) throws InputValidationException {
        setTitle(title);
        //setLecturer(lecturer);
        setSqf(sqf);
        coursestudents = new ArrayList<>();
        coursejournals = new ArrayList<>();


    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                //", lecturer=" + lecturer +
                ", sqf=" + sqf +
                ", coursestudents=" + coursestudents +
                ", attendance=" + attendance +
                '}';
    }


        public void addStudents(Student student){
            coursestudents.add(student);
    }

    public void addLesson(Journal journal) { coursejournals.add(journal); }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws InputValidationException {
        if (title.matches("(\\p{ASCII}){2,25}")) {
            this.title = title;
        }
        else {
            throw new InputValidationException("Unacceptable name");
        }
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    //public void setLecturer(Lecturer lecturer) {
     //   this.lecturer = lecturer;
    //}

    public int getSqf() {
        return sqf;
    }

    public void setSqf(int sqf) {
        this.sqf = sqf;
    }


    public Student searchByNumber(int snumber) {
        for (int i = 0; i < coursestudents.size(); i++) {

            if (coursestudents.get(i).getSnumber() == snumber){
                    Student current = coursestudents.get(i);
                return current;
            }
        }
        return null;
    }

    /*public void sortstud(){


        boolean swap = true;

        while (swap){
            swap = false;
            for (int i = 0; i <coursestudents.size()-1 ; i++) {
                if (coursestudents.get(i).getSsname().compareTo(coursestudents.get(i+1).getSsname())>0) {
                    Student temp = coursestudents.get(i+1);
                    coursestudents.set(i+1,coursestudents.get(i));
                    coursestudents.set(i,temp);

                    swap = true;

                }

            }
        }*/

    //}
}
