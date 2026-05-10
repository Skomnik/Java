import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InputValidationException {
        Scanner sc = new Scanner(System.in);

        // Creating arrays of cages, animals and staff
        Allcages allcages = new Allcages();
        Allanimals allanimals = new Allanimals();
        Allstaff staff = new Allstaff();

        //creating cages
        System.out.println("Creating cages");
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

        //creating animals
        System.out.println("Creating animals");
        allanimals.add(new Animal(101, "Ivan", "Ape", "Prey", 120320, 150523, "female"));
        allanimals.add(new Animal(102, "Marti", "Zebra", "Prey", 150418, 220622, "male"));
        allanimals.add(new Animal(103, "Mimi", "Marmoset Monkey", "Prey", 180719, 110624, "female"));
        allanimals.add(new Animal(104, "Sharhan", "Tiger", "Predator", 230516, 120725, "male"));
        allanimals.add(new Animal(105, "Bucks", "Rabbit", "Prey", 250921, 300324, "female"));
        allanimals.add(new Animal(106, "Peanut", "Guinea Pig", "Prey", 141122, 200924, "male"));

        allanimals.add(new Animal(107, "Aquila", "Eagle", "Predator", 190317, 180626, "female"));
        allanimals.add(new Animal(108, "Grim", "Vulture", "Predator", 110215, 140823, "male"));
        allanimals.add(new Animal(109, "Sova", "Owl", "Predator", 200918, 150524, "male"));
        allanimals.add(new Animal(110, "Straus", "Emu", "Prey", 110420, 110725, "female"));
        allanimals.add(new Animal(111, "Rico", "Penguin", "Prey", 170819, 250623, "male"));

        allanimals.add(new Animal(112, "Spike", "Bearded Dragon", "Prey", 120621, 300824, "male"));
        allanimals.add(new Animal(113, "lisa", "Lizard", "Prey", 150520, 190723, "female"));
        allanimals.add(new Animal(114, "Teo", "Chameleon", "Prey", 280322, 100925, "male"));

        System.out.println("done");

        // Create administrator and head keeper
        Administrator admin = new Administrator("Bruce", "Willis", "0283", "Beverly Hills", "Admin");
        HeadKeeper headKeeper = new HeadKeeper("Sylvester", "Stallone", "8483", "Tulsa", "Head Keeper");

        System.out.println("Welcome to zoo");

        boolean systemRunning = true;
        while (systemRunning) {   //loop for roles
            System.out.println("As who you want to act:");
            System.out.println("1. Administrator");
            System.out.println("2. Head Keeper");
            System.out.println("3. Exit ");


            int role = sc.nextInt();

            // admin roles
            if (role == 1) {
                boolean isAdmin = true;
                while (isAdmin) {
                    System.out.println("As admin you want to:");
                    System.out.println("1. Add Animal");
                    System.out.println("2. Add Keeper");
                    System.out.println("3. View All Animals");
                    System.out.println("4. View All Staff");
                    System.out.println("5. Remove Animal");
                    System.out.println("6. Remove Keeper");
                    System.out.println("7. Back to Main Menu");

                    int choice = sc.nextInt();


                    if (choice == 1) {  // Adding Animal

                        System.out.println("Enter animal id: ");
                        int animalid = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter animal name: ");
                        String animalname = sc.nextLine();
                        System.out.println("Enter animal type: ");
                        String animatype = sc.nextLine();
                        System.out.println("Enter animal category: ");
                        String animacategory = sc.nextLine();
                        System.out.println("Enter animal DOB: ");
                        int animaldob = sc.nextInt();
                        System.out.println("Enter animal DOA: ");
                        int animaldoa = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter animal sex: ");
                        String animalsex = sc.nextLine();

                        System.out.println("Animal passed health check? y/n");
                        String animalhealth = sc.nextLine();

                        if (animalhealth.equals("y") || animalhealth.equals("Y")){
                            Animal newAnimal = admin.createAnimal(animalid, animalname, animatype,animacategory,animaldob,animaldoa,animalsex);
                            allanimals.add(newAnimal);
                            System.out.println("done");
                        }

                        else {
                            System.out.println("We could not accept this animal");
                        }

                    }
                    else if (choice == 2) { // adding keeper
                        System.out.println("Enter keeper id: ");
                        int keeperid =sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter keeper name: ");
                        String keepername = sc.nextLine();
                        System.out.println("Enter keeper surname: ");
                        String keepersurname = sc.nextLine();
                        System.out.println("Enter keeper address: ");
                        String keeperaddress = sc.nextLine();
                        System.out.println("Enter keeper contact number: ");
                        String keepercontact = sc.nextLine();

                        Keeper newKeep = admin.createKeeper(keeperid,keepername,keepersurname,keeperaddress,keepercontact,"Keeper");
                        staff.add(newKeep);
                        System.out.println("done");
                    }
                    else if (choice == 3) {  //show animals
                        for (int i = 0; i < allanimals.size(); i++) System.out.println(i + ": " + allanimals.get(i));
                    }
                    else if (choice == 4) {   //show keepers
                        for (int i = 0; i < staff.size(); i++) System.out.println(i + ": " + staff.get(i));
                    }
                    else if (choice == 5) {  // remove animal by index
                        for (int i = 0; i < allanimals.size(); i++) System.out.println(i + ": " + allanimals.get(i));
                        System.out.print("Enter Animal index to remove: ");
                        int index = sc.nextInt();
                        allanimals.delete(index);
                        System.out.println("Animal removed from array.");
                    }
                    else if (choice == 6) {  // remove keeper by index
                        for (int i = 0; i < staff.size(); i++) System.out.println(i + ": " + staff.get(i));
                        System.out.print("Enter Staff index to remove: ");
                        int index = sc.nextInt();
                        staff.delete(index);
                        System.out.println("Staff removed from array.");
                    }
                    else if (choice == 7) {  //exit admin role
                        isAdmin = false;
                    }
                    else {
                        System.out.println("Wrong option");
                    }

                }
            }

            // Headkeeper roles
            else if (role == 2) {
                boolean isHK = true;
                while (isHK) {
                    System.out.println("As Head keeper you want to: ");
                    System.out.println("1. Allocate Animal to Cage");
                    System.out.println("2. Allocate Keeper to Cage");
                    System.out.println("3. Inform administrator (printout cages and keepers)");
                    System.out.println("4. View All Animals");
                    System.out.println("5. View All Staff");

                    System.out.println("6. Back to Main Menu");
                    int choice = sc.nextInt();

                    if (choice == 1) { // show all added animals but not allocated to cages
                        int count = 0;
                        for (int i = 0; i < allanimals.size(); i++) {
                            if (allanimals.get(i).isAnimalincage() == false) {
                                count++;
                            }
                        }
                        System.out.println("Allocate " + count + " animal to cages");

                        int cagenumber = 0;

                        for (int i = 0; i < allanimals.size(); i++) { //allocating
                            while (!allanimals.get(i).isAnimalincage()) {
                                System.out.println("to what cage put that animal " + allanimals.get(i).getType() + " " + allanimals.get(i).getName() + " (0 to skip)");
                                cagenumber = sc.nextInt();
                                if (cagenumber == 0) {
                                    break;
                                }
                                if (!allanimals.get(i).getCategory().equals("Predator") && allcages.get(cagenumber-1).isCagefree()) {
                                    headKeeper.assignAnimal(allanimals.get(i),allcages.get(cagenumber - 1));
                                    //allcages.get(cagenumber - 1).addAnimal(allanimals.get(i));
                                    allanimals.get(i).setAnimalincage(true);
                                }
                                else if (allanimals.get(i).getCategory().equals("Predator")) {
                                    System.out.println("Predator animals now need to be kept in a cage by themselves. Choose another cage:");
                                    if (allcages.get(cagenumber-1).getCapacity() == 1 && allcages.get(cagenumber-1).isCagefree()) {
                                        headKeeper.assignAnimal(allanimals.get(i),allcages.get(cagenumber - 1));
                                        //allcages.get(cagenumber - 1).addAnimal(allanimals.get(i));
                                        allanimals.get(i).setAnimalincage(true);
                                    }
                                }
                            }
                        }
                    }
                    else if (choice == 2) { //showing keepers that can take more cages
                        for (int i = 0; i < staff.size(); i++) {
                            if (staff.get(i).isAvailable()) {
                                System.out.println("Keeper " + staff.get(i).getFirstName() + " " + staff.get(i).getSurName() + " could get more cages");
                            }
                        }

                        for (int i = 0; i < allcages.size(); i++) {  //showing cages without keeper
                            if (!allcages.get(i).isHavekeeper()) {
                                System.out.println("Cage number: " + (i + 1) + " Have not keeper");
                            }
                        }

                        for (int i = 0; i < staff.size(); i++) {
                            while (staff.get(i).isAvailable()) {
                                System.out.println("Choose number cages for Keeper " + staff.get(i).getFirstName() + " " + staff.get(i).getSurName() + " 999 to exit");
                                int cagenumber = sc.nextInt();
                                if (cagenumber == 0) {
                                    break;
                                }

                                if (!allcages.get(cagenumber-1).isHavekeeper()) {
                                    headKeeper.assignKeeper(staff.get(i),allcages.get(cagenumber-1));
                                    //staff.get(i).assignCage(allcages.get(cagenumber-1));
                                    allcages.get(cagenumber-1).setHavekeeper(true);
                                }
                                else {
                                    System.out.println("that cage already have a keeper");
                                }
                            }
                        }
                    }
                    else if (choice == 3) { // showing info about cages (report to admin)
                        for (int i = 0; i < allcages.size(); i++) {
                            System.out.println("Cage " + (i+1) + " [" + allcages.get(i).getAnimalCount() + "/" + allcages.get(i).getCapacity() + "] Keeper: " + allcages.get(i).isHavekeeper());
                        }
                    }
                    else if (choice == 4) { // show all animals
                        for (int i = 0; i < allanimals.size(); i++) System.out.println(i + ": " + allanimals.get(i));
                    }
                    else if (choice == 5) { // show all keepers
                        for (int i = 0; i < staff.size(); i++) System.out.println(i + ": " + staff.get(i));
                    }

                    else if (choice == 6) { // exit from headkeepper role
                        isHK = false;
                    }
                }
            }
            else if (role == 3) { //exit program
                systemRunning = false;
                System.out.println("Exiting system");
            }
            else {
                System.out.println("Invalid role selection.");
            }
        }
    }
}