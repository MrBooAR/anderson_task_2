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
        Ticket ticket = ticketService.getTicketById("ID5");
        if (ticket != null) {
            System.out.println("Found Ticket: " + ticket);
        } else {
            System.out.println("Ticket not found.");
        }
    }
}
