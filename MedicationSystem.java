
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

    // Methods to add/delete patients/medications/doctors
    public void addPatient(Patient patient) {

        patients.add(patient);
    }

    public void deletePatient(Patient patient) {

        patients.remove(patient);
    }

    public void addMedication(Medication medication) {

        medications.add(medication);
    }

    public void deleteMedication(Medication medication) {

        medications.remove(medication);
    }

    public void addDoctor(Doctor doctor) {

        doctors.add(doctor);
    }

    public void deleteDoctor(Doctor doctor) {

        doctors.remove(doctor);
    }
}
