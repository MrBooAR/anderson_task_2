public class TicketService {
    public static void main(String[] args) {
        // Creating a full ticket with price
        Ticket fullTicket = new Ticket("1234".toCharArray(), "Hall A".toCharArray(), "001".toCharArray(),
                System.currentTimeMillis(), true, 'A', 7.505, 50.55);

        // Creating a limited ticket with price
        Ticket limitedTicket = new Ticket("Hall B".toCharArray(), "002".toCharArray());

        // Creating an empty ticket (default price)
        Ticket emptyTicket = new Ticket();

        // Displaying the tickets
        System.out.println("Full Ticket: " + fullTicket);
        System.out.println("Limited Ticket: " + limitedTicket);
        System.out.println("Empty Ticket: " + emptyTicket);
    }
}