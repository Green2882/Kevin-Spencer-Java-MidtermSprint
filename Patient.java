
import java.util.ArrayList;

public class Patient extends Person {

    // Instance variables
    private ArrayList<Medication> medications;
    private ArrayList<Prescription> prescriptions;

    // Constructor
    public Patient(String ID, String name, String age, String phoneNumber) {

        super(ID, name, age, phoneNumber);
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    // Method to add medications and prescriptions
    public void addMedication(Medication medication) {

        medications.add(medication);
    }

    public void addPrescription(Prescription prescription) {

        prescriptions.add(prescription);
    }

    // Getters
    public ArrayList<Medication> getMedications() {

        return medications;
    }

    public ArrayList<Prescription> getPrescriptions() {

        return prescriptions;
    }
}
