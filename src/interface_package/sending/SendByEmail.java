package interface_package.sending;

public class SendByEmail implements Sender {
    @Override
    public void send(Shareable shareable) {
        System.out.println("Sending via email: " + shareable.getDetails());
    }
}
