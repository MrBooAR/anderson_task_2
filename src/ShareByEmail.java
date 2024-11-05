public class ShareByEmail implements Shareable {
    private Ticket ticket;

    public ShareByEmail(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void share() {
        System.out.println("Sharing Ticket ID " + ticket.getId() + " by email.");
    }
}
