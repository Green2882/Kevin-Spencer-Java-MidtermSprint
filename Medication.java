
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The Medication class represents a medication in the medical system. It
 * includes details such as ID, name, dose, quantity, and expiry date.
 */
public class Medication {

    // Instance variables
    private String ID;
    private String name;
    private int dose;
    private int quantity;
    private LocalDate expiryDate;

    /**
     * Constructs a new Medication object. A random expiry date is automatically
     * generated between three years in the past and five years in the future.
     *
     * @param ID the unique ID assigned to the medication
     * @param name the name of the medication
     * @param dose the dosage amount of the medication
     * @param quantity the quantity available for this medication
     */
    public Medication(String ID, String name, int dose, int quantity) {
        this.ID = ID;
        this.name = name;
        this.dose = dose;
        this.quantity = quantity;
        this.expiryDate = getRandomExpiryDate();
    }

    /**
     * Generates a random expiry date within a range from three years ago to
     * five years in the future.
     *
     * @return a randomly generated LocalDate representing the expiry date
     */
    private LocalDate getRandomExpiryDate() {
        long start = LocalDate.now().minusYears(3).toEpochDay();
        long end = LocalDate.now().plusYears(5).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(start, end);
        return LocalDate.ofEpochDay(randomDay);
    }

    // Getters
    /**
     * Returns the expiry date of the medication.
     *
     * @return the expiry date as a LocalDate
     */
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    /**
     * Returns the medication ID.
     *
     * @return the medication's ID
     */
    public String getID() {
        return ID;
    }

    /**
     * Returns the medication name.
     *
     * @return the medication's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the dosage amount of the medication.
     *
     * @return the dose as an integer
     */
    public int getDose() {
        return dose;
    }

    /**
     * Returns the quantity of the medication available.
     *
     * @return the quantity as an integer
     */
    public int getQuantity() {
        return quantity;
    }

    // Setters
    /**
     * Sets a new expiry date for the medication.
     *
     * @param expiryDate the new expiry date as a LocalDate
     */
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Sets the medication ID.
     *
     * @param ID the new ID for the medication
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Sets the medication name.
     *
     * @param name the new name for the medication
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the dosage amount of the medication.
     *
     * @param dose the new dosage amount
     */
    public void setDose(int dose) {
        this.dose = dose;
    }

    /**
     * Sets the quantity of the medication available.
     *
     * @param quantity the new quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return a string with all info about a specific prescription.
     */
    @Override
    public String toString() {
        return "ID: " + ID
                + ", Name: " + name
                + ", Dose: " + dose
                + ", Quantity: " + quantity
                + ", Expiry Date: " + expiryDate;
    }
}
