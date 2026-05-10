
public class testAnimal {
    public static void main(String[] args) throws InputValidationException {
        System.out.println("test animal");
        Animal animal1= new Animal(12,"Po","Panda", "Pray",021120, 021122, "male");

        System.out.println(animal1);

        Allanimals allanimals = new Allanimals();
        allanimals.add(new Animal(132,"Marti","Zebra", "Pray",021120, 021122, "male"));
        allanimals.add(new Animal(132,"Glory","Hyppo", "Pray",021120, 021122, "female"));
        allanimals.add(new Animal(132,"Alex","Lion", "Predator",021120, 021122, "male"));
        allanimals.add(new Animal(132,"Rico","Penguin", "Pray",021120, 021122, "male"));
        System.out.println(allanimals.get(1));

    }
}
