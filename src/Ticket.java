public class Ticket implements Identifiable{
    protected int id; // Max 4 digits/characters
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
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + new String(String.valueOf(id)) +
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
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}

