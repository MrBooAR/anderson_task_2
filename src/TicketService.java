import java.util.ArrayList;
import java.util.List;

public class TicketService {
    private List<Ticket> tickets;

    public TicketService() {
        // Initialize the list with 10 tickets
        tickets = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            tickets.add(new Ticket(
                    ("ID" + i).toCharArray(),
                    ("ConcertHall" + i).toCharArray(),
                    ("E00" + i).toCharArray(),
                    System.currentTimeMillis(),
                    i % 2 == 0,    // Set promo true for even indexed tickets
                    'A',
                    5.0,
                    20.0 + i
            ));
        }
    }
}
