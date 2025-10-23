
import java.time.LocalDate;

/**
 * The Prescription class represents a prescription record in the medical
 * system. It associates a doctor, patient, and medication together.
 */
public class Prescription {

    // Instance variables
    private String ID;
    private Doctor doctor;
    private Patient patient;
    private Medication medication;
    private LocalDate prescribeDate;
    private LocalDate prescriptionExp;

    /**
     * Constructs a new Prescription object. The prescription automatically
     * expires one year after the prescribed date.
     *
     * @param ID the unique ID assigned to the prescription
     * @param doctor the doctor who issued the prescription
     * @param patient the patient receiving the prescription
     * @param medication the medication prescribed
     * @param prescribeDate the date the prescription was issued
     */
    public Prescription(String ID, Doctor doctor, Patient patient, Medication medication, LocalDate prescribeDate) {
        this.ID = ID;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.prescribeDate = prescribeDate;
        this.prescriptionExp = prescribeDate.plusYears(1); // Expires one year after prescribed
    }

    // Getters
    /**
     * Returns the prescription ID.
     *
     * @return the unique ID of the prescription
     */
    public String getID() {
        return this.ID;
    }

    /**
     * Returns the doctor who issued the prescription.
     *
     * @return the Doctor object associated with the prescription
     */
    public Doctor getDoctor() {
        return this.doctor;
    }

    /**
     * Returns the patient who received the prescription.
     *
     * @return the Patient object associated with the prescription
     */
    public Patient getPatient() {
        return this.patient;
    }

    /**
     * Returns the medication that was prescribed.
     *
     * @return the Medication object associated with the prescription
     */
    public Medication getMedication() {
        return this.medication;
    }

    /**
     * Returns the date the prescription was issued.
     *
     * @return the prescription issue date as a LocalDate
     */
    public LocalDate getPrescribeDate() {
        return this.prescribeDate;
    }

    /**
     * Returns the expiry date of the prescription.
     *
     * @return the expiry date as a LocalDate
     */
    public LocalDate getPrescriptionExp() {
        return this.prescriptionExp;
    }

    /**
     * Returns a string representation of the prescription details, including
     * doctor, patient, medication, and dates.
     *
     * @return a formatted string with prescription information
     */
    @Override
    public String toString() {
        return "Prescription ID: " + ID
                + ", Doctor: " + doctor.getName()
                + ", Patient: " + patient.getName()
                + ", Medication: " + medication.getName()
                + ", Prescribed: " + prescribeDate
                + ", Expires: " + prescriptionExp;
    }
}
