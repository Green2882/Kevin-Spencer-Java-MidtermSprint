
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

    // Methods to edit/delete medications/patients/doctors
    public void editDoctor(String doctorID, String newName, String newPhoneNumber, String newSpecialization) {

        // When editing, any fields you do not want to change, just pass null for that field
        for (Doctor d : doctors) {
            if (d.getID().equals(doctorID)) {
                if (newName != null) {
                    d.setName(newName);
                }
                if (newPhoneNumber != null) {
                    d.setPhoneNumber(newPhoneNumber);
                }
                if (newSpecialization != null) {
                    d.setSpecialization(newSpecialization);
                }
                System.out.println("Doctor updated successfully.");
                return;
            }
        }
        System.out.println("Doctor not found.");
    }

    public void editPatient(String patientID, String newName, String newPhoneNumber) {

        for (Patient p : patients) {
            if (p.getID().equals(patientID)) {
                if (newName != null) {
                    p.setName(newName);
                }
                if (newPhoneNumber != null) {
                    p.setPhoneNumber(newPhoneNumber);
                }
                System.out.println("Patient updated successfully");
                return;
            }
        }
        System.out.println("Patient not found");
    }

    public void editMedication(String medicationID, String newName, Integer newDose, Integer newQuantity, LocalDate newExpiryDate) {

        for (Medication m : medications) {
            if (m.getID().equals(medicationID)) {
                if (newName != null) {
                    m.setName(newName);
                }
                if (newDose != null) {
                    m.setDose(newDose);
                }
                if (newQuantity != null) {
                    m.setQuantity(newQuantity);
                }
                if (newExpiryDate != null) {
                    m.setExpiryDate(newExpiryDate);
                }
                System.out.println("Medication updated successfully");
                return;
            }
        }
        System.out.println("Medication not found");
    }

    public void deleteDoctor(String doctorID) {

        for (Doctor d : doctors) {
            if (d.getID().equals(doctorID)) {
                doctors.remove(d);
                System.out.println("Doctor removed successfully");
                return;
            }
        }
        System.out.println("Doctor not found");
    }

    public void deletePateint(String patientID) {

        for (Patient p : patients) {

            if (p.getID().equals(patientID)) {
                patients.remove(p);
                System.out.println("Patient removed successfully");
                return;
            }
        }
        System.out.println("Patient not found");
    }

    public void deleteMedication(String medicationID) {

        for (Medication m : medications) {
            if (m.getID().equals(medicationID)) {
                medications.remove(m);
                System.out.println("Medication removed successfully");
                return;
            }
        }
        System.out.println("Medication not found");
    }

}
