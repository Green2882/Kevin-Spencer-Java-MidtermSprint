
import java.util.ArrayList;

/**
 * The Doctor class extends the Person class and represents a doctor in the
 * medical system. It includes the doctor's specialization and a list of their
 * patients.
 */
public class Doctor extends Person {

    // Instance variables
    private String specialization;
    private ArrayList<Patient> patients;

    /**
     * Constructs a new Doctor object and specifies specialization. Creates an
     * empty list for storing the doctor's assigned patients.
     *
     * @param ID the unique ID assigned to the doctor
     * @param name the name of the doctor
     * @param age the age of the doctor
     * @param phoneNumber the contact phone number of the doctor
     * @param specialization the medical specialization of the doctor
     */
    public Doctor(String ID, String name, String age, String phoneNumber, String specialization) {
        super(ID, name, age, phoneNumber);
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    /**
     * Adds a patient to the doctor's list of patients.
     *
     * @param patient the Patient object to add
     */
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    /**
     * Returns the list of patients assigned to the doctor.
     *
     * @return an ArrayList of Patient objects
     */
    public ArrayList<Patient> getPatients() {
        return patients;
    }

    /**
     * Sets the doctor's specialization.
     *
     * @param specialization the new specialization of the doctor
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    /**
     * @return a string with all the info about a specific doctor.
     */
    public String toString() {
        return super.toString()
                + ", Specialization: " + specialization
                + ", Patients: " + patients.size();
    }

}
