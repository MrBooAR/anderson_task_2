import java.util.Objects;
import java.lang.reflect.Field;

public class Ticket implements Modifiable, Printable {
    @NullableWarning
    private int id; // Max 4 digits/characters
    private char[] concertHall; // Max 10 characters
    private char[] eventCode; // 3 digits
    private long time; // Unix timestamp for ticket creation
    private boolean isPromo; // Promo ticket or not
    private char stadiumSector; // 'A' to 'C'
    private double maxBackpackWeight; // Max allowed backpack weight in kg (with grams precision)
    private double price; // Price of the ticket

    // Constructor for full initialization
    public Ticket(int id, char[] concertHall, char[] eventCode, Long time,
                  boolean isPromo, char stadiumSector, double maxBackpackWeight, double price) {
        this.id = id;
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.time = (time != null) ? time : System.currentTimeMillis(); // Set current time if no time is given
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.maxBackpackWeight = maxBackpackWeight;
        this.price = price;
    }

    // Constructor for limited initialization
    public Ticket(char[] concertHall, char[] eventCode) {
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.time = System.currentTimeMillis(); // Automatically sets to current time
        this.id = 0; // default empty id
        this.isPromo = false; // default to non-promo
        this.stadiumSector = ' '; // default sector
        this.maxBackpackWeight = 0.0; // default weight
        this.price = 0.0; // Set price as provided
    }

    // Constructor for creating an empty ticket
    public Ticket() {
        this.id = 0; // Default empty ID
        this.concertHall = new char[10]; // Default empty concert hall
        this.eventCode = new char[3]; // Default empty event code
        this.time = System.currentTimeMillis(); // Default to current time
        this.isPromo = false; // Default to non-promo
        this.stadiumSector = ' '; // Default sector
        this.maxBackpackWeight = 0.0; // Default weight
        this.price = 0.0; // Default price

        //checkForNulls();
    }

    private void checkForNulls() {
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(NullableWarning.class)) {
                field.setAccessible(true);
                try {
                    if (field.getInt(this) == 0) { // Check if id is 0
                        System.out.println("Variable [" + field.getName() + "] is null in [" + this.getClass().getSimpleName() + "]!");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    // Optionally override the default printContent method
    @Override
    public void printContent() {
        System.out.println("Ticket Details: " + this);
    }

    // Method to retrieve all field values as a String
    @Override
    public String getAllValues() {
        return "Ticket{" +
                "id=" + id +
                ", concertHall=" + new String(concertHall) +
                ", eventCode=" + new String(eventCode) +
                ", time=" + time +
                ", isPromo=" + isPromo +
                ", stadiumSector=" + stadiumSector +
                ", maxBackpackWeight=" + maxBackpackWeight +
                ", price=" + price +
                '}';
    }

    @Override
    public String toString() {
        return getAllValues();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Check if the same object
        if (obj == null || getClass() != obj.getClass()) return false; // Check for null and class match
        Ticket ticket = (Ticket) obj; // Cast to Ticket
        return id == ticket.id; // Compare IDs for equality
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // Generate hash code based on ID
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public void setStadiumSector(char stadiumSector) {
        this.stadiumSector = stadiumSector;
    }
}

