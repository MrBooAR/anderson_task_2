public class ShareByPhone implements Shareable{
    private Ticket ticket;

    public ShareByPhone(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void share() {
        System.out.println("Sharing Ticket ID " + ticket.getId() + " by phone.");
    }
}
