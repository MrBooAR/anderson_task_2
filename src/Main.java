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

    }
}
