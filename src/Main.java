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
        System.out.println("Full Ticket: " + fullTicket);
        System.out.println("Limited Ticket: " + limitedTicket);
        System.out.println("Empty Ticket: " + emptyTicket);

        TicketService ticketService = new TicketService();

        // Retrieve a ticket by ID
        Ticket ticket = ticketService.getTicketById(String.valueOf(5));
        if (ticket != null) {
            System.out.println("Found Ticket: " + ticket);
        } else {
            System.out.println("Ticket not found.");
        }


        // Modify allowed fields using TicketModifiable interface methods
        fullTicket.setTime(System.currentTimeMillis() + 10000); // Update time
        fullTicket.setStadiumSector('B'); // Update stadium sector

        // Display all values using Valuable interface method
        System.out.println("Updated Ticket Values: " + fullTicket.getAllValues());

        Shareable shareByPhone = new ShareByPhone(ticket);
        Shareable shareByEmail = new ShareByEmail(ticket);

        // Sharing the ticket by different methods
        shareByPhone.share(); // Calls the phone sharing method
        shareByEmail.share(); // Calls the email sharing method

        User[] users = new User[2]; // Array of User type

        // Creating instances of Client and Admin
        users[0] = new Client();
        users[1] = new Admin();

        // Iterate through users and call printRole
        for (User user : users) {
            user.printRole(); // Calls the overridden method based on the actual object type
            // Call unique methods based on the instance type
            if (user instanceof Client) {
                ((Client) user).getTicket(ticket); // Client gets a ticket
            } else if (user instanceof Admin) {
                ((Admin) user).checkTicket(ticket); // Admin checks a ticket
            }

        }
    }
}
