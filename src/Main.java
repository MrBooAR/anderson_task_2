import model.Admin;
import model.Client;
import model.Ticket;
import model.User;
import service.TicketService;
import interface_package.sending.SendByEmail;
import interface_package.sending.SendByPhone;
import interface_package.sending.Sender;

public class Main {
    public static void main(String[] args) {
        // Creating tickets
        Ticket fullTicket = new Ticket(1234, "Hall A".toCharArray(), "001".toCharArray(),
                System.currentTimeMillis(), true, 'A', 7.505, 50.55);
        Ticket limitedTicket = new Ticket("Hall B".toCharArray(), "002".toCharArray());
        Ticket emptyTicket = new Ticket();

        // Display tickets
        System.out.println("Full Ticket: " + fullTicket);
        System.out.println("Limited Ticket: " + limitedTicket);
        System.out.println("Empty Ticket: " + emptyTicket);

        TicketService ticketService = new TicketService();
        Ticket ticket = ticketService.getTicketById(String.valueOf(5));

        if (ticket != null) {
            System.out.println("Found Ticket: " + ticket);
        } else {
            System.out.println("Ticket not found.");
        }

        // Modify ticket fields
        fullTicket.setTime(System.currentTimeMillis() + 10000);
        fullTicket.setStadiumSector('B');
        System.out.println("Updated Ticket: " + fullTicket);

        // Use Senders
        Sender sendByEmail = new SendByEmail();
        Sender sendByPhone = new SendByPhone();
        sendByEmail.send(ticket);
        sendByPhone.send(ticket);

        // User roles
        User[] users = new User[2];
        users[0] = new Client();
        users[1] = new Admin();

        for (User user : users) {
            user.printRole();
            if (user instanceof Client) {
                ((Client) user).getTicket(ticket);
            } else if (user instanceof Admin) {
                ((Admin) user).checkTicket(ticket);
            }
        }
    }
}
