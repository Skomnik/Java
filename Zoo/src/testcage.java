public class testcage {
    public static void main(String[] args) {
        Cage cage1 = new Cage(1,10);
        Cage cage2 = new Cage(2,10);
        Cage cage3 = new Cage(3,10);
        Cage cage4 = new Cage(4,10);
        Cage cage5 = new Cage(5,10);

        Cage cage6 = new Cage(6,5);
        Cage cage7 = new Cage(7,5);
        Cage cage8 = new Cage(8,5);

        Cage cage9 = new Cage(9,1);
        Cage cage10 = new Cage(10,1);
        Cage cage11 = new Cage(11,1);
        Cage cage12 = new Cage(12,1);
        Cage cage13 = new Cage(13,1);
        Cage cage14 = new Cage(14,1);
        Cage cage15 = new Cage(15,1);

        Allcages allcages = new Allcages();

        allcages.add(new Cage(1,10));
        allcages.add(new Cage(2,10));
        allcages.add(new Cage(3,10));
        allcages.add(new Cage(4,10));
        allcages.add(new Cage(5,10));

        allcages.add(new Cage(6,5));
        allcages.add(new Cage(7,5));
        allcages.add(new Cage(8,5));

        allcages.add(new Cage(9,1));
        allcages.add(new Cage(10,1));
        allcages.add(new Cage(11,1));
        allcages.add(new Cage(12,1));
        allcages.add(new Cage(13,1));
        allcages.add(new Cage(14,1));
        allcages.add(new Cage(15,1));


        System.out.println(allcages.get(1));



    }
}
