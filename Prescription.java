
import java.time.LocalDate;

public class Prescription {

    // Instance variables
    private String ID;
    private Doctor doctor;
    private Patient patient;
    private Medication medication;
    private LocalDate prescriptionExp;

    // Constructor
    public Prescription(String ID, Doctor doctor, Patient patient, Medication medication, LocalDate prescriptionExp) {

        this.ID = ID;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.prescriptionExp = prescriptionExp;
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
                + ", Expires: " + prescriptionExp;
    }
}
