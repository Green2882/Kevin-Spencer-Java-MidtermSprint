
import java.util.ArrayList;

/**
 * The Patient class extends the Person class and represents a patient in the
 * medical system. It includes lists for the patient's medications and
 * prescriptions.
 */
public class Patient extends Person {

    // Instance variables
    private ArrayList<Medication> medications;
    private ArrayList<Prescription> prescriptions;

    /**
     * Constructs a new Patient object. Creates empty lists for storing the
     * patient's medications and prescriptions.
     *
     * @param ID the unique ID assigned to the patient
     * @param name the name of the patient
     * @param age the age of the patient
     * @param phoneNumber the contact phone number of the patient
     */
    public Patient(String ID, String name, String age, String phoneNumber) {
        super(ID, name, age, phoneNumber);
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    /**
     * Adds a medication to the patient's list of medications.
     *
     * @param medication the Medication object to add
     */
    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    /**
     * Adds a prescription to the patient's list of prescriptions.
     *
     * @param prescription the Prescription object to add
     */
    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    /**
     * Removes a medication from the patient's list of medications.
     *
     * @param medication the Medication object to remove
     */
    public void removeMedication(Medication medication) {
        medications.remove(medication);
    }

    /**
     * Removes a prescription from the patient's list of prescriptions.
     *
     * @param prescription the Prescription object to remove
     */
    public void removePrescription(Prescription prescription) {
        prescriptions.remove(prescription);
    }

    /**
     * Returns the list of medications assigned to the patient.
     *
     * @return an ArrayList of Medication objects
     */
    public ArrayList<Medication> getMedications() {
        return medications;
    }

    /**
     * Returns the list of prescriptions assigned to the patient.
     *
     * @return an ArrayList of Prescription objects
     */
    public ArrayList<Prescription> getPrescriptions() {
        return prescriptions;
    }

    /**
     * @return a string with all the info about a specific patient.
     */
    @Override
    public String toString() {
        return super.toString()
                + ", Medications: " + medications.size()
                + ", Prescriptions: " + prescriptions.size();
    }
}
