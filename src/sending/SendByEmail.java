package sending;

import interfaceticket.Sender;
import interfaceticket.Shareable;
import userANDticket.Ticket;

public class SendByEmail implements Sender {
    @Override
    public void send(Shareable shareable) {
        if (shareable instanceof Ticket) {
            Ticket ticket = (Ticket) shareable;
            System.out.println("Sending ticket via email: " + ticket);
        } else {
            System.out.println("Unsupported object type for email sending.");
        }
    }
}
