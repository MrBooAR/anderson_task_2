public class Client extends User {

    @Override
    public void printRole() {
        System.out.println("Role: Client");
    }

    public void getTicket(Ticket ticket) {
        System.out.println("Client is getting a ticket.");
    }
}