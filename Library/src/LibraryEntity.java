abstract class LibraryEntity {
    public int id;
    public String name;


    public LibraryEntity (int id, String name) {
        this.id = id;
        this.name = name;
    }
       public abstract void performRole();

}
