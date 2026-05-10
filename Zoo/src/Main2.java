
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) throws InputValidationException {

        System.out.println("Welcome to our zoo");
        System.out.println("Creating cages");
        Allcages allcages = new Allcages();

        allcages.add(new Cage(1, 10));
        allcages.add(new Cage(2, 10));
        allcages.add(new Cage(3, 10));
        allcages.add(new Cage(4, 10));
        allcages.add(new Cage(5, 10));

        allcages.add(new Cage(6, 5));
        allcages.add(new Cage(7, 5));
        allcages.add(new Cage(8, 5));

        allcages.add(new Cage(9, 1));
        allcages.add(new Cage(10, 1));
        allcages.add(new Cage(11, 1));
        allcages.add(new Cage(12, 1));
        allcages.add(new Cage(13, 1));
        allcages.add(new Cage(14, 1));
        allcages.add(new Cage(15, 1));
        System.out.println("done");

        System.out.println("Creating animals");
        Allanimals allanimals = new Allanimals();

        allanimals.add(new Animal(101, "Ivan", "Ape", "Pray", 120320, 150523, "female"));
        allanimals.add(new Animal(102, "Marti", "Zebra", "Pray", 150418, 220622, "male"));
        allanimals.add(new Animal(103, "Mimi", "Marmoset Monkey", "Pray", 180719, 110624, "female"));
        allanimals.add(new Animal(104, "Sharhan", "Tiger", "Predator", 230516, 120725, "male"));
        allanimals.add(new Animal(105, "Bucks", "Rabbit", "Pray", 250921, 300324, "female"));
        allanimals.add(new Animal(106, "Peanut", "Guinea Pig", "Pray", 141122, 200924, "male"));

        allanimals.add(new Animal(107, "Aquila", "Eagle", "Predator", 190317, 180626, "female"));
        allanimals.add(new Animal(108, "Grim", "Vulture", "Predator", 110215, 140823, "male"));
        allanimals.add(new Animal(109, "Sova", "Owl", "Predator", 200918, 150524, "male"));
        allanimals.add(new Animal(110, "Straus", "Emu", "Pray", 110420, 110725, "female"));
        allanimals.add(new Animal(111, "Rico", "Penguin", "Pray", 170819, 250623, "male"));

        allanimals.add(new Animal(112, "Spike", "Bearded Dragon", "Pray", 120621, 300824, "male"));
        allanimals.add(new Animal(113, "lisa", "Lizard", "Pray", 150520, 190723, "female"));
        allanimals.add(new Animal(114, "Teo", "Chameleon", "Pray", 280322, 100925, "male"));

        System.out.println("done");

        Allstaff staff = new Allstaff();

        Administrator admin = new Administrator("Bruce", "Willis","0283","Beverly hills","Administrator");

        HeadKeeper headKeeper = new HeadKeeper("Silvester", "Stalone","8483", "Talsa", "Head Keeper");


        Scanner sc = new Scanner(System.in);
        int choice =0;
        System.out.println("Choose your role:");
        System.out.println("1. administrator");
        System.out.println("2. Head Keeper");
        int role = sc.nextInt();
        if (role==1){
            System.out.println("As administrator you want to:");
            System.out.println("1. Add Animal");
            System.out.println("2. Remove Animal");
            System.out.println("3. Add Keeper");
            System.out.println("4. Remove Keeper");
            System.out.println("5. Check all animals in their cages");
            choice = sc.nextInt();
            if (choice==1){
                allanimals.add(new Animal(107, "Aquila", "Eagle", "Predator", 190317, 180626, "female"));
            }
            if (choice==2){
                System.out.println("Enter number of animal: ");
                choice=sc.nextInt();
                allanimals.delete(choice);
            }
            if (choice==3){
                staff.add(new Keeper(1, "Tom", "Hanks", "Hollywood", "093472", "keeper", allcages.get(0)));
            }
            if (choice==4){
                System.out.println("Enter number of keeper: ");
                choice=sc.nextInt();
                staff.delete(choice);
            }
        }
        if (role==2){
            System.out.println("As HeadKeeper you want to:");
            System.out.println("1. Allocate Animal");
            System.out.println("2. Allocate Keeper");
            System.out.println("3. Make a report to Administrator");
            System.out.println("4. Check free space in cages ");
            System.out.println("5. Check keepers and their cages");
            choice = sc.nextInt();
            if (choice==1){

            }
            if (choice==2){

            }
            if (choice==3){

            }
        }


        int count = 0;
        for (int i = 0; i < allanimals.size(); i++) {
            if (allanimals.get(i).isAnimalincage() == false) {
                count++;
            }
        }
        System.out.println("Allocate " + count + " animal to cages");




        System.out.println();
        int cagenumber = 0;

        for (int i = 0; i < allanimals.size(); i++) {
            while (!allanimals.get(i).isAnimalincage()) {
                if (allanimals.get(i).isAnimalincage() == false) {
                    System.out.println("to what cage put that animal " + allanimals.get(i).getType() + " " + allanimals.get(i).getName());
                    cagenumber = sc.nextInt();
                    if (cagenumber == 999) {
                        break;
                    }
                    sc.nextLine();
                    if (!allanimals.get(i).getCategory().equals("Predator") && allcages.get(cagenumber-1).isCagefree()) {
                        allcages.get(cagenumber - 1).addAnimal(allanimals.get(i));
                        allanimals.get(i).setAnimalincage(true);

                    }
                    if (allanimals.get(i).getCategory().equals("Predator")) {
                        System.out.println("Predator animals now need to be kept in a cage by themselves. Choose another cage:");
                        if (allcages.get(cagenumber-1).getCapacity() == 1 && allcages.get(cagenumber-1).isCagefree()) {
                            allcages.get(cagenumber - 1).addAnimal(allanimals.get(i));
                            allanimals.get(i).setAnimalincage(true);
                        }
                      /* // cagenumber = sc.nextInt();
                       for (int j = 0; j < allcages.size(); j++) {
                            if (allcages.get(j).getCapacity() == 1 || allcages.get(j).isCagefree()) {
                                allcages.get(cagenumber - 1).addAnimal(allanimals.get(i));
                                allanimals.get(i).setAnimainlcage(true);
                                System.out.println("That is OK");
                            }

                        }

                       */

                    }
                }
            }
        }

        System.out.println("Creating staff");


        staff.add(new Keeper(1, "Tom", "Hanks", "Hollywood", "093472", "keeper", allcages.get(0)));
        staff.add(new Keeper(1, "Will", "Smith", "Hollywood", "0934724", "keeper", allcages.get(1)));
        staff.add(new Keeper(1, "Nikolas", "Cage", "Hollywood", "0934724", "keeper", allcages.get(1)));

        System.out.println("done");

        for (int i = 0; i < staff.size(); i++) {
            if (staff.get(i).isAvailable()) {
                System.out.println("Keeper " + staff.get(i).getFirstName() + " " + staff.get(i).getSurName() + " could get more cages");
            }

        }

        for (int i = 0; i < allcages.size(); i++) {
            if (!allcages.get(i).isHavekeeper()) {
                System.out.println("Cage number: " + (i + 1) + " Have not keeper");
            }
        }



        for (int i = 0; i < staff.size(); i++) {
            while (staff.get(i).isAvailable()) {
                System.out.println("Choose number cages for Keeper " + staff.get(i).getFirstName() + " " + staff.get(i).getSurName() + " 999 to exit");
                cagenumber = sc.nextInt();
                if (cagenumber == 999) {
                    break;
                }

                if (!allcages.get(cagenumber-1).isHavekeeper()) {
                    staff.get(i).assignCage(allcages.get(cagenumber-1));
                    allcages.get(cagenumber-1).setHavekeeper(true);
                }
                else {
                    System.out.println("that cage already have a keeper");
                }

            }
        }


        /*staff.get(0).assignCage(allcages.get(0));
        allcages.get(0).setHavekeeper(true);
        staff.get(0).assignCage(allcages.get(1));
        allcages.get(1).setHavekeeper(true);
        staff.get(0).assignCage(allcages.get(2));
        allcages.get(2).setHavekeeper(true);
        staff.get(0).assignCage(allcages.get(3));
        allcages.get(3).setHavekeeper(true);
        staff.get(0).assignCage(allcages.get(4));
        allcages.get(4).setHavekeeper(true);

        staff.get(1).assignCage(allcages.get(5));
        allcages.get(5).setHavekeeper(true);
        staff.get(1).assignCage(allcages.get(6));
        allcages.get(6).setHavekeeper(true);
        staff.get(1).assignCage(allcages.get(7));
        allcages.get(7).setHavekeeper(true);
        staff.get(1).assignCage(allcages.get(8));
        allcages.get(8).setHavekeeper(true);
        staff.get(1).assignCage(allcages.get(9));
        allcages.get(9).setHavekeeper(true);

         */

        System.out.println();
        for (int i = 0; i < staff.size(); i++) {
            if (staff.get(i).isAvailable()) {
                System.out.println("Keeper " + staff.get(i).getFirstName() + " " + staff.get(i).getSurName() + " could get more cages");
            }

        }
        System.out.println();
        for (int i = 0; i < allcages.size(); i++) {
            System.out.println("Cage number: " + (i + 1));
            System.out.println("capacity " + allcages.get(i).getCapacity() + " used: " + allcages.get(i).getAnimalCount());
            allcages.get(i).displayAnimals();

        }


    }
}