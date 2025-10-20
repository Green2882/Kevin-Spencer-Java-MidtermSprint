import java.time.LocalDate;

public class Medication {
    private int ID;
    private String name;
    private int quantity;
    private LocalDate expiryDate;

    Medication(int ID, String name, int quantity, LocalDate expiryDate) {
        this.ID = ID;
        this.name = name;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String tosString() {
        return "ID: " + ID + " Name: " + name + " Quantity: " + quantity + " Exp Date: " + expiryDate;
    }
}