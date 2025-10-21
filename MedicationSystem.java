
import java.util.ArrayList;

public class MedicationSystem {

    // Instance variables
    private ArrayList<Patient> patients;
    private ArrayList<Doctor> doctors;
    private ArrayList<Medication> medications;
    private ArrayList<Prescription> prescriptions;

    // Constructor
    public MedicationSystem() {

        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        medications = new ArrayList<>();
        prescriptions = new ArrayList<>();
    }
}
