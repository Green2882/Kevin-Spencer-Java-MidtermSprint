
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The MedicationSystem class manages the entire pharmacy system, including
 * doctors, patients, medications, and prescriptions.
 *
 */
public class MedicationSystem {

    // Instance variables
    private ArrayList<Patient> patients;
    private ArrayList<Doctor> doctors;
    private ArrayList<Medication> medications;
    private ArrayList<Prescription> prescriptions;

    /**
     * Constructs a new MedicationSystem. Initializes empty lists for patients,
     * doctors, medications, and prescriptions.
     */
    public MedicationSystem() {
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        medications = new ArrayList<>();
        prescriptions = new ArrayList<>();
    }

    /**
     * Adds a patient to the system.
     *
     * @param patient the Patient object to add
     */
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    /**
     * Removes a patient from the system.
     *
     * @param patient the Patient object to remove
     */
    public void deletePatient(Patient patient) {
        patients.remove(patient);
    }

    /**
     * Adds a medication to the system.
     *
     * @param medication the Medication object to add
     */
    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    /**
     * Removes a medication from the system.
     *
     * @param medication the Medication object to remove
     */
    public void deleteMedication(Medication medication) {
        medications.remove(medication);
    }

    /**
     * Adds a doctor to the system.
     *
     * @param doctor the Doctor object to add
     */
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    /**
     * Removes a doctor from the system.
     *
     * @param doctor the Doctor object to remove
     */
    public void deleteDoctor(Doctor doctor) {
        doctors.remove(doctor);
    }

    /**
     * Assigns a patient to a doctor using their IDs.
     *
     * @param doctorID the ID of the doctor
     * @param patientID the ID of the patient
     */
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
            System.out.println("Patient added successfully.");
        } else {
            System.out.println("Doctor or patient not found.");
        }
    }

    /**
     * Creates and records a new prescription for a patient from a doctor.
     *
     * @param doctorID the ID of the doctor issuing the prescription
     * @param patientID the ID of the patient receiving the prescription
     * @param medicationID the ID of the prescribed medication
     * @param prescribeDate the date the prescription was issued
     */
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
            Prescription prescription = new Prescription(newPrescriptionID, doctor, patient, medication, prescribeDate);

            prescriptions.add(prescription);
            patient.addPrescription(prescription);
            patient.addMedication(medication);

            System.out.println("Prescription added successfully (" + prescribeDate + ").");
        } else {
            System.out.println("Doctor, patient, or medication not found.");
        }
    }

    /**
     * Edits a doctor's information. Pass null for any field that should remain
     * unchanged.
     *
     * @param doctorID the doctor's ID
     * @param newName the new name
     * @param newPhoneNumber the new phone number
     * @param newSpecialization the new specialization
     */
    public void editDoctor(String doctorID, String newName, String newPhoneNumber, String newSpecialization) {
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

    /**
     * Edits a patient's information. Pass null for any field that should remain
     * unchanged.
     *
     * @param patientID the patient's ID
     * @param newName the new name
     * @param newPhoneNumber the new phone number
     */
    public void editPatient(String patientID, String newName, String newPhoneNumber) {
        for (Patient p : patients) {
            if (p.getID().equals(patientID)) {
                if (newName != null) {
                    p.setName(newName);
                }
                if (newPhoneNumber != null) {
                    p.setPhoneNumber(newPhoneNumber);
                }
                System.out.println("Patient updated successfully.");
                return;
            }
        }
        System.out.println("Patient not found.");
    }

    /**
     * Edits a medication's details. Pass null for any field that should remain
     * unchanged.
     *
     * @param medicationID the medication ID
     * @param newName the new name
     * @param newDose the new dose
     * @param newQuantity the new quantity
     * @param newExpiryDate the new expiry date
     */
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
                System.out.println("Medication updated successfully.");
                return;
            }
        }
        System.out.println("Medication not found.");
    }

    /**
     * Generates and prints a full system report, listing all doctors,
     * medications, patients, and prescriptions.
     */
    public void generateSystemReport() {
        System.out.println("=== System Report ===");
        System.out.println("\nDoctors:");
        for (Doctor d : doctors) {
            System.out.println(d);
        }

        System.out.println("\nMedications:");
        for (Medication m : medications) {
            System.out.println(m);
        }

        System.out.println("\nPatients:");
        for (Patient p : patients) {
            System.out.println(p);
        }

        System.out.println("\nPrescriptions:");
        for (Prescription p : prescriptions) {
            System.out.println(p);
        }
    }

    /**
     * Checks all medications and prints those that are expired.
     */
    public void checkMedicationExp() {
        for (Medication m : medications) {
            if (m.getExpiryDate().isBefore(LocalDate.now())) {
                System.out.println(m.getID() + ", " + m.getName() + " is expired.");
            }
        }
    }

    /**
     * Prints all prescriptions written by a specific doctor.
     *
     * @param doctorID the ID of the doctor
     */
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

    /**
     * Increases the quantity of every medication in stock by 10 units.
     */
    public void restockMeds() {
        for (Medication m : medications) {
            m.setQuantity(m.getQuantity() + 10);
        }
        System.out.println("All medications have been restocked.");
    }

    /**
     * Prints all medications and prescribing doctors for a specific patient.
     *
     * @param patientName the name of the patient to search for
     */
    public void printPatientMedsDoctor(String patientName) {
        for (Patient p : patients) {
            if (p.getName().equalsIgnoreCase(patientName)) {
                System.out.println("Patient: " + p.getName());
                System.out.println("Medications and Prescribing Doctors:");
                boolean found = false;

                for (Prescription pr : prescriptions) {
                    if (pr.getPatient().getName().equalsIgnoreCase(patientName)) {
                        System.out.println("- " + pr.getMedication().getName()
                                + " (Prescribed by " + pr.getDoctor().getName() + ")");
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

    /**
     * Prints all prescriptions for each patient issued within the past year.
     */
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

    /**
     * Searches for a patient by name.
     *
     * @param name the patient's name
     * @return a string of patient details
     */
    public String searchPatientByName(String name) {
        for (Patient p : patients) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p.toString();
            }
        }
        System.out.println("Patient not found.");
        return null;
    }

    /**
     * Searches for a doctor by name.
     *
     * @param name the doctor's name
     * @return a string of doctor details
     */
    public String searchDoctorByName(String name) {
        for (Doctor d : doctors) {
            if (d.getName().equalsIgnoreCase(name)) {
                return d.toString();
            }
        }
        System.out.println("Doctor not found.");
        return null;
    }

    /**
     * Searches for a medication by name.
     *
     * @param name the medication name
     * @return a string of medication details
     */
    public String searchMedicationByName(String name) {
        for (Medication m : medications) {
            if (m.getName().equalsIgnoreCase(name)) {
                return m.toString();
            }
        }
        System.out.println("Medication not found.");
        return null;
    }

    /**
     * Returns all patients in the system.
     *
     * @return an ArrayList of Patient objects
     */
    public ArrayList<Patient> getPatients() {
        return patients;
    }

    /**
     * Returns all doctors in the system.
     *
     * @return an ArrayList of Doctor objects
     */
    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    /**
     * Returns all medications in the system.
     *
     * @return an ArrayList of Medication objects
     */
    public ArrayList<Medication> getMedications() {
        return medications;
    }
}
