package model;

import exceptions.NullableWarning;
import interface_package.Printable;
import interface_package.sending.Shareable;
import java.lang.reflect.Field;
import java.util.Objects;

public class Ticket implements Printable, Shareable {
    @NullableWarning
    private int id; // Max 4 digits
    private char[] concertHall; // Max 10 characters
    private char[] eventCode; // Max 3 characters
    private long time; // Unix timestamp for ticket creation
    private boolean isPromo; // Promo ticket or not
    private char stadiumSector; // 'A' to 'C'
    private double maxBackpackWeight; // Backpack weight in kg (with gram precision)
    private double price; // Ticket price

    // Constructor for full initialization
    public Ticket(int id, char[] concertHall, char[] eventCode, Long time,
                  boolean isPromo, char stadiumSector, double maxBackpackWeight, double price) {
        this.id = id;
        this.concertHall = concertHall != null ? concertHall : new char[10];
        this.eventCode = eventCode != null ? eventCode : new char[3];
        this.time = (time != null) ? time : System.currentTimeMillis();
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.maxBackpackWeight = maxBackpackWeight;
        this.price = price;
    }

    // Constructor for limited initialization
    public Ticket(char[] concertHall, char[] eventCode) {
        this(0, concertHall, eventCode, null, false, ' ', 0.0, 0.0);
    }

    // Constructor for default ticket
    public Ticket() {
        this(0, new char[10], new char[3], null, false, ' ', 0.0, 0.0);
    }

    // Check for nullable fields
    private void checkForNulls() {
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(NullableWarning.class)) {
                field.setAccessible(true);
                try {
                    if (field.get(this) == null) {
                        System.out.println("Variable [" + field.getName() + "] is null in [" + this.getClass().getSimpleName() + "]!");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void printContent() {
        System.out.println(this);
    }

    @Override
    public String getDetails() {
        return toString();
    }

    @Override
    public String toString() {
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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ticket ticket = (Ticket) obj;
        return id == ticket.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setStadiumSector(char stadiumSector) {
        this.stadiumSector = stadiumSector;
    }
}