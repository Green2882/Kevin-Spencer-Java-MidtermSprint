
/**
 * The Person class represents a general person in the system.
 * Class is inherited by both the Doctor and Patient classes.
 */
public abstract class Person {

    // Instance variables
    private String ID;
    private String name;
    private String age;
    private String phoneNumber;

    /**
     * Constructs a new Person object.
     *
     * @param ID the unique ID assigned to the person
     * @param name the name of the person
     * @param age the age of the person
     * @param phoneNumber the phone number of the person
     */
    public Person(String ID, String name, String age, String phoneNumber) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    // Getters
    /**
     * Returns the person's unique ID.
     *
     * @return the person's ID
     */
    public String getID() {
        return ID;
    }

    /**
     * Returns the person's name.
     *
     * @return the person's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the person's age.
     *
     * @return the person's age
     */
    public String getAge() {
        return age;
    }

    /**
     * Returns the person's phone number.
     *
     * @return the person's phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setters
    /**
     * Sets the person's ID.
     *
     * @param ID the new ID for the person
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Sets the person's name.
     *
     * @param name the new name for the person
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the person's age.
     *
     * @param age the new age for the person
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * Sets the person's phone number.
     *
     * @param phoneNumber the new phone number for the person
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return a string with all the info about a specific person.
     */
    @Override
    public String toString() {
        return "ID: " + ID + ", Name: " + name + ", Age: " + age + ", Phone Number: " + phoneNumber;
    }
}
