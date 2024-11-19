package interface_package.sending;

public class SendByPhone implements Sender {
    @Override
    public void send(Shareable shareable) {
        System.out.println("Sending via phone: " + shareable.getDetails());
    }
}