package userANDticket;

public class Client extends User {

    @Override
    public void printRole() {
        System.out.println("Role: userANDticket.Client");
    }

    public void getTicket(Ticket ticket) {
        System.out.println("userANDticket.Client is getting a ticket.");
    }
}