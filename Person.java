
public abstract class Person {

    // Instance variables
    private String ID;
    private String name;
    private String age;
    private String phoneNumber;

    // Constrcutor
    Person(String ID, String name, String age, String phoneNumber) {

        this.ID = ID;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    // Getters
    public String getID() {

        return this.ID;
    }

    public String getName() {

        return this.name;
    }

    public String getAge() {

        return this.age;
    }

    public String getPhoneNumer() {

        return this.phoneNumber;
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
}
