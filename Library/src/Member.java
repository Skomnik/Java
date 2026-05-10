class Member extends LibraryEntity {

    public Member(int id, String name) {
        super(id, name);
    }

    public void borrowBook(Book book) {
        if (book.getStatus().equals("Available")) {
            book.updateStatus("Issued");
            System.out.println("Member \"" + name + "\" borrowed the book: \"" + book.name + "\"");
        } else {
            System.out.println("Book \"" + book.name + "\" is not available for borrowing. Current status: " + book.getStatus());
        }
    }

    public void returnBook(Book book, boolean isDamaged) {
        if (book.getStatus().equals("Issued")) {
            if (isDamaged) {
                book.updateStatus("Damaged");
                System.out.println("Member \"" + name + "\" returned the book \"" + book.name + "\" in a damaged condition.");
            } else {
                book.updateStatus("Available");
                System.out.println("Member \"" + name + "\" returned the book \"" + book.name + "\" in good condition.");
            }
        } else {
            System.out.println("Book \"" + book.name + "\" was not issued. Cannot be returned.");
        }
    }

    @Override
    public void performRole() {
        System.out.println("Member \"" + name + "\" can borrow and return books.");
    }
}