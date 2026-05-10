import java.util.Date;

public class Student {
    private int snumber;
    private String sfname;
    private String ssname;
    private String sdob;
    private String sadress;
    private Double attendance;

    @Override
    public String toString() {
        return
                "SN: " + snumber +
                " " + sfname +
                " " + ssname ;

                //" attendance = " + attendance ;
    }

    public Student(int snumber, String sfname, String ssname, String sdob, String sadress) throws InputValidationException {

        setSnumber(snumber);
        setSfname(sfname);
        setSsname(ssname);
        setSdob(sdob);
        setSadress(sadress);
        setAttendance(0.0);

    }


    public Double getAttendance() {
        return attendance;
    }

    public void setAttendance(Double attendance) {
        this.attendance = attendance;
    }

    public int getSnumber() {
        return snumber;
    }

    public void setSnumber(int snumber) {
        if (snumber>0) {
            this.snumber = snumber;
        }
    }

    public String getSfname() {
        return sfname;
    }

    public void setSfname(String sfname) throws InputValidationException {
        if (sfname.matches("(\\p{ASCII}){2,25}")) {
            this.sfname = sfname;
        }
        else {
            throw new InputValidationException("Wrong firstname");
        }
    }

    public String getSsname() {
        return ssname;
    }

    public void setSsname(String ssname) throws InputValidationException {
        if (ssname.matches("(\\p{ASCII}){2,25}")) {

            this.ssname = ssname;
        }
        else {
            throw new InputValidationException("Wrong Surname");
        }
    }

    public String getSdob() {
        return sdob;
    }

    public void setSdob(String sdob) throws InputValidationException {
        if (sdob.matches("(\\p{ASCII}){4,20}")) {
            this.sdob = sdob;
        }
        else {
            throw new InputValidationException("Wrong DOB");
        }

    }

    public String getSadress() {
        return sadress;
    }

    public void setSadress(String sadress) {
        this.sadress = sadress;
    }
}
