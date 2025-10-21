import java.util.ArrayList;

public class Doctor extends Person {

    // Instance Variables
    private String specialization;
    private ArrayList<Patient> patients;

    Doctor(String ID, String name, String age, String phoneNumber, String specialization) {
        super(ID, name, age, phoneNumber);
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }
}
