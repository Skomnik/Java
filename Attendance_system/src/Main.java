import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InputValidationException {


        Allstudents allstudents = new Allstudents();

        allstudents.add(new Student(143, "Brad", "Pitt", "02.11.1986", "Somewhere"));
        allstudents.add(new Student(232, "John", "Dow", "02.11.1986", "Somewhere"));
        allstudents.add(new Student(3324, "Joe", "Shoe", "02.11.1986", "Somewhere"));
        allstudents.add(new Student(387, "Tom", "Hanks", "02.11.1986", "Somewhere"));
        allstudents.add(new Student(3987, "Bruce", "Willis", "02.11.1986", "Somewhere"));
        allstudents.add(new Student(563, "Edward", "Norton", "02.11.1986", "Somewhere"));
        allstudents.add(new Student(564, "Tom", "Cruise", "02.11.1986", "Somewhere"));
        allstudents.add(new Student(984, "Morgan", "Freeman", "02.11.1986", "Somewhere"));
        allstudents.add(new Student(3532, "Jonny", "Depp", "02.11.1986", "Somewhere"));
        allstudents.add(new Student(624, "Leonardo", "Dicaprio", "02.11.1986", "Somewhere"));
       // allstudents.add(new Student(128, "Tom", "Holland", "02.11.1986", "Somewhere"));
        allstudents.sortstud();


        Lecturer lecturer1 = new Lecturer("Alice", "McDonald", 200.00, "Milkway 3");
        lecturer1.setLogin("Nik");
        lecturer1.setPassword("123");


        Scanner sc = new Scanner(System.in);

        String login=null;
        String password=null;
        Hashpassword mainHasher = new Hashpassword();

        while (!lecturer1.getLogin().equals(login) || !lecturer1.getPassword().equals(mainHasher.hash(password))) {
            System.out.println("Authorization");
            System.out.print("Enter login: ");
            login = sc.nextLine();

            System.out.print("Enter password: ");
            password = sc.nextLine();

            if (!lecturer1.getLogin().equals(login) || !lecturer1.getPassword().equals(mainHasher.hash(password))) {
                System.out.println("Wrong login or password.");
            }

        }

        System.out.println("List of students: ");
        for (int i = 0; i < allstudents.students.size(); i++) {
            System.out.println(i + 1 + " : " + allstudents.students.get(i));
        }


        int choice;
        while (true) {

            System.out.println("Welcome " + lecturer1.getLfname());
            System.out.println("1. Create a course");
            System.out.println("2. Create attendance journal");
            System.out.println("3. Students attendance that drops below 70%");
            System.out.println("4. Change password");
            System.out.println("5. Exit");


            choice = sc.nextInt();
            sc.nextLine();


            if (choice == 1) {

                System.out.print("Enter course name: ");
                String coursename = sc.nextLine();

                System.out.print("Enter SQF: ");
                int coursesqf = sc.nextInt();

                sc.nextLine();

                Course course = new Course(coursename, coursesqf);


                course.coursestudents.addAll(allstudents.students);
                lecturer1.lectorCourses.add(course);

                System.out.println("Course created");

            }


            else if (choice == 2) {

                if (lecturer1.lectorCourses.isEmpty()) {
                    throw new InputValidationException("Course not created");
                    //System.out.println("Course not created");
                    //Course course = new Course("Default course", lecturer1,1234);

                }

                System.out.println("Choose what course you want to use");
                for (int i = 0; i < lecturer1.lectorCourses.size(); i++) {
                    System.out.println(i+1 +":" + lecturer1.lectorCourses.get(i).getTitle());
                }
                System.out.println("Enter number: ");

                int coursechoice = 0;
                coursechoice = sc.nextInt();

                sc.nextLine();

                if (coursechoice<1 || coursechoice > lecturer1.lectorCourses.size()){
                    coursechoice=1;

                    System.out.println("Incorrect choice, the program will work with the first course.");
                    System.out.println("You have choose " + lecturer1.lectorCourses.get(coursechoice-1).getTitle() );
                }

                Course course = lecturer1.lectorCourses.get(coursechoice-1);
                System.out.println("You have choose " + lecturer1.lectorCourses.get(coursechoice-1).getTitle() );

                System.out.print("Enter lesson date: ");
                String date = sc.nextLine();

                Journal journal = new Journal(course, date);


                System.out.println("Type students order number to mark attendance (type 999 to finish):");


                for (int i = 0; i < course.coursestudents.size(); i++) {
                    Student s = course.coursestudents.get(i);
                    System.out.println((i + 1) + ". " + s.getSfname() + " " + s.getSsname());
                }


                while (true) {
                    int studentChoice = sc.nextInt();
                    sc.nextLine();

                    if (studentChoice == 999) {
                        break;
                    }

                    if (studentChoice > 0 && studentChoice <= course.coursestudents.size()) {

                        Student current = course.coursestudents.get(studentChoice - 1);

                        if (!journal.studentArrayList.contains(current)) {
                            journal.addAttendance(current);
                            System.out.println(current.getSfname() + " Done");
                        }


                        //journal.addAttendance(current);
                        //System.out.println(current.getSfname() + " done");
                    } else {
                        throw new InputValidationException("Wrong");
                        //System.out.println("Wrong");
                    }
                }


                course.coursejournals.add(journal);
                System.out.println("done " + date);
            }


            else if (choice == 3) {

                if (lecturer1.lectorCourses.isEmpty()) {
                    throw new InputValidationException("There is no course");
                    //System.out.println("Have not course");

                }

                System.out.println("Choose what course you want to use");
                for (int i = 0; i < lecturer1.lectorCourses.size(); i++) {
                    System.out.println(i+1 +":" + lecturer1.lectorCourses.get(i).getTitle());
                }
                System.out.println("Enter number: ");

                int coursechoicetwo = 0;
                coursechoicetwo = sc.nextInt();

                sc.nextLine();




                Course course = lecturer1.lectorCourses.get(coursechoicetwo-1);
                int totalLessons = course.coursejournals.size();

                if (totalLessons == 0) {
                    //System.out.println("No lessons recorded yet.");
                    throw new InputValidationException("No lessons recorded yet.");

                }

                System.out.println("Students with attendance below 70%:");

                for (int i = 0; i < course.coursestudents.size(); i++) {
                    Student student = course.coursestudents.get(i);
                    int attended = 0;

                    for (int j = 0; j < course.coursejournals.size(); j++) {
                        Journal journal = course.coursejournals.get(j);

                        if (journal.studentArrayList.contains(student)) {
                            attended++;
                        }
                    }

                    //int percent = ( attended / totalLessons) * 100;
                    double percent = ((double) attended / totalLessons) * 100;
                    //if (percent < 70) {
                        System.out.println(student.getSfname() + " " + student.getSsname() + " " + Math.round(percent) + "%");
                   // }
                }
            }

            else if (choice == 4) {
                System.out.println("Type new password: ");
                String pass = sc.nextLine();
                lecturer1.setPassword(pass);
                System.out.println("Password changed");
            }

            else if (choice == 5) {
                System.out.println("Exiting");
                break;
            }
        }

    }
}
