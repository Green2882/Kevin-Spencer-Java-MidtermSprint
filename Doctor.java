
import java.util.ArrayList;

public class Doctor extends Person {

    // Instance Variables
    private String specialization;
    private ArrayList<Patient> patients;

    public Doctor(String ID, String name, String age, String phoneNumber, String specialization) {
        super(ID, name, age, phoneNumber);
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    // Method to add/get patients
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    // Method to setSpecialization
    public void setSpecialization(String specialization) {

        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Specialization: " + specialization
                + ", Patients: " + patients.size();
    }

}
