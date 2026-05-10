import java.util.ArrayList;

public class Allcourses {

    private ArrayList<Course> courses;

    public Allcourses() {

        courses = new ArrayList<Course>();
    }

    public void add(Course course) {

        courses.add(course);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
}

