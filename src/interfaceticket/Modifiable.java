package interfaceticket;

public interface Modifiable {
    int getId();         // Method to retrieve the ID
    void setId(int id);  // Method to set the ID
    void setTime(long time);
    void setStadiumSector(char stadiumSector);
}