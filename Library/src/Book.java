class Book extends LibraryEntity {
    String status = "Available";


    public Book(int id, String name) {
        super(id, name);
    }
    //A String status attribute that can be "Available," "Issued," or "Damaged."

    public String getStatus() {
        return status;
    }

    public void updateStatus(String newStatus) {
        if (newStatus.equals("Available") || newStatus.equals("Issued") || newStatus.equals("Damaged")) {
            this.status = newStatus;
            System.out.println("Book \"" + name + "\" status updated to: " + newStatus);
        }
    }
        @Override
        public void performRole() {
            System.out.println("This is a book named \"" + name + "\" with status: " + status);
        }

    }




