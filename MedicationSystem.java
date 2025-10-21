
import java.time.LocalDate;
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

    // Add a patient to a doctors list
    public void addPatientToDoctor(String doctorID, String patientID) {

        Doctor doctor = null;
        Patient patient = null;

        for (Doctor d : doctors) {
            if (d.getID().equals(doctorID)) {
                doctor = d;
                break;
            }
        }

        for (Patient p : patients) {
            if (p.getID().equals(patientID)) {
                patient = p;
                break;
            }
        }

        if (doctor != null && patient != null) {
            doctor.addPatient(patient);
            System.out.println("Patient added succesfully");
        } else {
            System.out.println("Doctor or patient not found");
        }

    }

    // Method to accept a prescription
    public void acceptPrescription(String doctorID, String patientID, String medicationID) {

        Doctor doctor = null;
        Patient patient = null;
        Medication medication = null;

        for (Doctor d : doctors) {
            if (d.getID().equals(doctorID)) {
                doctor = d;
                break;
            }
        }

        for (Patient p : patients) {
            if (p.getID().equals(patientID)) {
                patient = p;
                break;
            }
        }

        for (Medication m : medications) {
            if (m.getID().equals(medicationID)) {
                medication = m;
                break;
            }
        }

        if (doctor != null && patient != null && medication != null) {
            String newPrescriptionID = String.valueOf(prescriptions.size() + 1);

            Prescription prescription = new Prescription(newPrescriptionID, doctor, patient, medication, LocalDate.now().plusYears(1));

            prescriptions.add(prescription);
            patient.addPrescription(prescription);
            patient.addMedication(medication);

            System.out.println("Prescription added succesfully");
        } else {
            System.out.println("Doctor, patient, or medication not found");
        }

    }
}
