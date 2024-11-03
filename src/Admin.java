public class Admin extends User {
    @Override
    public void printRole() {
        System.out.println("Role: Admin");
    }

    public void checkTicket(Ticket ticket) {
        System.out.println("Admin is checking tickets.");
    }
}