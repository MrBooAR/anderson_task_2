import interfaceticket.Sender;
import sending.SendByEmail;
import sending.SendByPhone;
import userANDticket.*;

public class Main {
    public static void main(String[] args) {
        // Creating a full ticket with price
        Ticket fullTicket = new Ticket(1234, "Hall A".toCharArray(), "001".toCharArray(),
                System.currentTimeMillis(), true, 'A', 7.505, 50.55);

// Creating a limited ticket with price
        Ticket limitedTicket = new Ticket("Hall B".toCharArray(), "002".toCharArray());

// Creating an empty ticket (default price)
        Ticket emptyTicket = new Ticket();

// Displaying the tickets
        System.out.println("Full userANDticket.Ticket: " + fullTicket);
        System.out.println("Limited userANDticket.Ticket: " + limitedTicket);
        System.out.println("Empty userANDticket.Ticket: " + emptyTicket);

        TicketService ticketService = new TicketService();

        // Retrieve a ticket by ID
        Ticket ticket = ticketService.getTicketById(String.valueOf(5));
        if (ticket != null) {
            System.out.println("Found userANDticket.Ticket: " + ticket);
        } else {
            System.out.println("userANDticket.Ticket not found.");
        }


        // Modify allowed fields using TicketModifiable interface methods
        fullTicket.setTime(System.currentTimeMillis() + 10000); // Update time
        fullTicket.setStadiumSector('B'); // Update stadium sector

        // Display all values using Valuable interface method
        System.out.println("Updated userANDticket.Ticket Values: " + fullTicket);

        // Using Senders
        Sender sendByEmail = new SendByEmail();
        Sender sendByPhone = new SendByPhone();

        sendByEmail.send(ticket); // Sending via email
        sendByPhone.send(ticket); // Sending via phone

        User[] users = new User[2]; // Array of userANDticket.User type

        // Creating instances of userANDticket.Client and userANDticket.Admin
        users[0] = new Client();
        users[1] = new Admin();

        // Iterate through users and call printRole
        for (User user : users) {
            user.printRole(); // Calls the overridden method based on the actual object type
            // Call unique methods based on the instance type
            if (user instanceof Client) {
                ((Client) user).getTicket(ticket); // userANDticket.Client gets a ticket
            } else if (user instanceof Admin) {
                ((Admin) user).checkTicket(ticket); // userANDticket.Admin checks a ticket
            }

        }

    }
}
