
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
    public void acceptPrescription(String doctorID, String patientID, String medicationID, LocalDate prescribeDate) {

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

            Prescription prescription
                    = new Prescription(newPrescriptionID, doctor, patient, medication, prescribeDate);

            prescriptions.add(prescription);
            patient.addPrescription(prescription);
            patient.addMedication(medication);

            System.out.println("Prescription added successfully (" + prescribeDate + ")");
        } else {
            System.out.println("Doctor, patient, or medication not found.");
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

    // Method to print a report of all system data
    public void generateSystemReport() {

        System.out.println("System Report:");
        System.out.println("Doctors:");
        for (Doctor d : doctors) {
            System.out.println(d);
        }

        System.out.println();
        System.out.println("Medications:");
        for (Medication m : medications) {
            System.out.println(m);
        }

        System.out.println();
        System.out.println("Patients");
        for (Patient p : patients) {
            System.out.println(p);
        }

        System.out.println();
        System.out.println("Prescriptions:");
        for (Prescription p : prescriptions) {
            System.out.println(p);
        }
    }

    // Method to check for expired medications
    public void checkMedicationExp() {

        for (Medication m : medications) {
            if (m.getExpiryDate().isBefore(LocalDate.now())) {
                System.out.println(m.getID() + ", " + m.getName() + ", is expired");
                return;
            }
        }
    }

    // Method to print all prescriptions given by a certain doctor
    public void printDoctorPrescriptions(String doctorID) {

        boolean found = false;

        for (Doctor d : doctors) {
            if (d.getID().equals(doctorID)) {
                System.out.println("Prescriptions issued by Dr. " + d.getName() + ":");

                for (Prescription pr : prescriptions) {
                    if (pr.getDoctor().getID().equals(doctorID)) {
                        System.out.println(pr);
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("No prescriptions found for this doctor.");
                }
                return;
            }
        }
        System.out.println("Doctor not found in the system.");
    }

    // Method to restock medications in pharmacy
    public void restockMeds() {

        for (Medication m : medications) {
            m.setQuantity(m.getQuantity() + 10);
        }
        System.out.println("All medications have been restocked");
    }

    // Method to search a patients medications and doctors
    public void printPatientMedsDoctor(String patientName) {

        for (Patient p : patients) {
            if (p.getName().equalsIgnoreCase(patientName)) {
                System.out.println("Patient: " + p.getName());
                System.out.println("Medications and Prescribing Doctors:");

                boolean found = false;

                for (Prescription pr : prescriptions) {
                    if (pr.getPatient().getName().equalsIgnoreCase(patientName)) {
                        System.out.println("- " + pr.getMedication().getName()
                                + " (Prescribed by Dr. " + pr.getDoctor().getName() + ")");
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("No prescriptions found for this patient.");
                }
                return;
            }
        }

        System.out.println("Patient not found in the system.");
    }

    // Method to print all patients' prescriptions from the past year
    public void printPastYearsPrescriptions() {
        LocalDate oneYearAgo = LocalDate.now().minusYears(1);
        boolean anyFound = false;

        for (Patient p : patients) {
            boolean patientHasRecent = false;

            for (Prescription pr : prescriptions) {
                if (pr.getPatient().getID().equals(p.getID())
                        && pr.getPrescribeDate().isAfter(oneYearAgo)) {

                    if (!patientHasRecent) {
                        System.out.println("\nPatient: " + p.getName());
                        System.out.println("Prescriptions in the last year:");
                        patientHasRecent = true;
                        anyFound = true;
                    }

                    System.out.println("- " + pr.getMedication().getName()
                            + " (Prescribed on: " + pr.getPrescribeDate() + ")");
                }
            }

            if (patientHasRecent) {
                System.out.println();
            }
        }

        if (!anyFound) {
            System.out.println("No prescriptions found from the past year.");
        }
    }

}
