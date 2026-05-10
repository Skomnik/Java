
public class Main {
    public static void main(String[] args) {
        // Create books
        Book book1 = new Book(1, "1984");
        Book book2 = new Book(2, "I am Robot");

        // Create librarian
        Librarian librarian = new Librarian(1, "Alice");

        // Create member
        //Member member = new Member(1, "Bob");

        // Librarian issues a book to a member
        //librarian.manageBook(book1, "Issue");
        //member.borrowBook(book1);

        // Member returns the book in damaged condition
        //member.returnBook(book1, true);

        // Librarian updates the book’s status to reflect the damage
        //librarian.manageBook(book1, "Mark Damaged");

        // Check final statuses
        book1.updateStatus("Issued");
        book1.performRole();
        book2.performRole();
        librarian.manageBook();

    }
}