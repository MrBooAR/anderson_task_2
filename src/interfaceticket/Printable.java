package interfaceticket;

public interface Printable {
    // Default print method that can be overridden
    default void printContent() {
        System.out.println(this.toString());
    }
}
