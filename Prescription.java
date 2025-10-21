
import java.time.LocalDate;

public class Prescription {

    // Instance variables
    private int ID;
    private Doctor doctor;
    private Patient patient;
    private Medication medication;
    private LocalDate prescriptionExp;

    // Constructor
    public Prescription(int ID, Doctor doctor, Patient patient, Medication medication, LocalDate prescriptionExp) {

        this.ID = ID;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.prescriptionExp = prescriptionExp;
    }
}
