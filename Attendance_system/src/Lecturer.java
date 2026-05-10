import java.util.ArrayList;

public class Lecturer {
    private String lfname;
    private String lsname;
    private Double salary;
    private String ladress;

    public ArrayList<Course> lectorCourses;
    private String login;
    private String password;

    private Hashpassword hasher = new Hashpassword();

    public Lecturer(String lfname, String lsname, Double salary, String ladress) {
        setLfname(lfname);
        setLsname(lsname);
        setSalary(salary);
        setLadress(ladress);
        lectorCourses = new ArrayList<>();

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = hasher.hash(password);
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "lfname='" + lfname + '\'' +
                ", lsname='" + lsname + '\'' +
                ", salary=" + salary +
                ", ladress='" + ladress + '\'' +
                '}';
    }

    public String getLfname() {
        return lfname;
    }

    public void setLfname(String lfname) {
        this.lfname = lfname;
    }

    public String getLsname() {
        return lsname;
    }

    public void setLsname(String lsname) {
        this.lsname = lsname;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getLadress() {
        return ladress;
    }

    public void setLadress(String ladress) {
        this.ladress = ladress;
    }
}
