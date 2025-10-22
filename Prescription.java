
import java.time.LocalDate;

public class Prescription {

    // Instance variables
    private String ID;
    private Doctor doctor;
    private Patient patient;
    private Medication medication;
    private LocalDate prescribeDate;
    private LocalDate prescriptionExp;

    // Constructor
    public Prescription(String ID, Doctor doctor, Patient patient, Medication medication, LocalDate prescribeDate) {
        this.ID = ID;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.prescribeDate = prescribeDate;
        this.prescriptionExp = prescribeDate.plusYears(1); // expires 1 year after prescribed
    }

    // Getters
    public String getID() {
        return this.ID;
    }

    public Doctor getDoctor() {
        return this.doctor;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public Medication getMedication() {
        return this.medication;
    }

    public LocalDate getPrescribeDate() {
        return this.prescribeDate;
    }

    public LocalDate getPrescriptionExp() {
        return this.prescriptionExp;
    }

    // toString
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
