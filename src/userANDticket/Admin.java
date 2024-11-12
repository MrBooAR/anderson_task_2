package userANDticket;

public class Admin extends User {
    @Override
    public void printRole() {
        System.out.println("Role: userANDticket.Admin");
    }

    public void checkTicket(Ticket ticket) {
        System.out.println("userANDticket.Admin is checking tickets.");
    }
}