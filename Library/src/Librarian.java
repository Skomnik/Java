class Librarian extends LibraryEntity {

    public Librarian(int id, String name) {
        super(id, name);
    }

    public void manageBook(Book book, String action) {
        switch (action) {
            case "Issue":
                if (book.getStatus().equals("Available")) {
                    book.updateStatus("Issued");
                    System.out.println("Librarian \"" + name + "\" issued the book: \"" + book.name + "\"");
                } else {
                    System.out.println("Book \"" + book.name + "\" cannot be issued. Current status: " + book.getStatus());
                }
                break;
            case "Return":
                if (book.getStatus().equals("Issued")) {
                    book.updateStatus("Available");
                    System.out.println("Librarian \"" + name + "\" returned the book: \"" + book.name + "\"");
                } else {
                    System.out.println("Book \"" + book.name + "\" is not issued. Cannot be returned.");
                }
                break;
            case "Mark Damaged":
                book.updateStatus("Damaged");
                System.out.println("Librarian \"" + name + "\" marked the book as damaged: \"" + book.name + "\"");
                break;
            default:
                System.out.println("Invalid action: " + action);
        }
    }

    @Override
    public void performRole() {
        System.out.println("Librarian \"" + name + "\" manages books and assists members.");
    }
}
