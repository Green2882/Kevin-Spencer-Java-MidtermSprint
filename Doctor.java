
public class Doctor extends Person {

    // Instance Variables
    private String specialization;
    private Patient[] patients;

    Doctor(String ID, String name, String age, String phoneNumber, String specialization, Patient[] patients) {
        super(ID, name, age, phoneNumber);
        this.specialization = specialization;
        this.patients = patients;
    }
}
