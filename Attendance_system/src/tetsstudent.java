public class tetsstudent {
    public static void main(String[] args) throws InputValidationException {
        Student student = new Student(1,"Qwer","Qazwsx","010110","Road 7, Glasgow");
        System.out.println(student.getSnumber()+ " "+ student.getSfname()+" "+ student.getSsname());
        student.setSfname("Tom");
        student.setSsname("Jones");
        System.out.println(student.getSnumber()+ " "+ student.getSfname()+" "+ student.getSsname());

        Student student1 = new Student(0,"Q","Qazwsx","010110","Road 7, Glasgow");
        System.out.println(student1.getSnumber()+ " "+ student1.getSfname()+" "+ student1.getSsname());
        Student student2 = new Student(1,"Qwer","Q","010110","Road 7, Glasgow");
        System.out.println(student2.getSnumber()+ " "+ student2.getSfname()+" "+ student2.getSsname());
        Student student3 = new Student(1,"Qwer","Qazwsx","01","Road 7, Glasgow");
        System.out.println(student3.getSnumber()+ " "+ student3.getSfname()+" "+ student3.getSsname());
    }

}
