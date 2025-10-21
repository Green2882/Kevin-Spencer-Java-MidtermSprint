
public abstract class Person {

    // Instance variables
    private String ID;
    private String name;
    private String age; // or int if you prefer numeric
    private String phoneNumber;

    // Constructor
    public Person(String ID, String name, String age, String phoneNumber) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    // Getters
    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setters
    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // toString
    @Override
    public String toString() {
        return "ID: " + ID + ", Name: " + name + ", Age: " + age + ", Phone Number: " + phoneNumber;
    }
}
