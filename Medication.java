
import java.time.LocalDate;

public class Medication {

    private String ID;
    private String name;
    private int dose;
    private int quantity;
    private LocalDate expiryDate;

    Medication(String ID, String name, int dose, int quantity, LocalDate expiryDate) {
        this.ID = ID;
        this.name = name;
        this.dose = dose;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getDose() {

        return this.dose;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDose(int dose) {

        this.dose = dose;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return "ID: " + ID + " Name: " + name + " Dose: " + dose + " Quantity: " + quantity + " Exp Date: " + expiryDate;
    }
}
