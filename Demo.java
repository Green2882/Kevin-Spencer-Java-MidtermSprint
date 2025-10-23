
import java.time.LocalDate;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        MedicationSystem system = new MedicationSystem();

// ===== CREATE DOCTORS =====
        Doctor d1 = new Doctor("D001", "Dr. Adams", "45", "555-1001", "Cardiology");
        Doctor d2 = new Doctor("D002", "Dr. Brown", "50", "555-1002", "Pediatrics");
        Doctor d3 = new Doctor("D003", "Dr. Carter", "38", "555-1003", "Dermatology");
        Doctor d4 = new Doctor("D004", "Dr. Davis", "42", "555-1004", "Neurology");
        Doctor d5 = new Doctor("D005", "Dr. Evans", "55", "555-1005", "Oncology");

        system.addDoctor(d1);
        system.addDoctor(d2);
        system.addDoctor(d3);
        system.addDoctor(d4);
        system.addDoctor(d5);

// ===== CREATE PATIENTS =====
        Patient p1 = new Patient("P001", "John Doe", "30", "555-2001");
        Patient p2 = new Patient("P002", "Jane Smith", "28", "555-2002");
        Patient p3 = new Patient("P003", "Alice Johnson", "40", "555-2003");
        Patient p4 = new Patient("P004", "Bob White", "35", "555-2004");
        Patient p5 = new Patient("P005", "Emily Green", "22", "555-2005");

        system.addPatient(p1);
        system.addPatient(p2);
        system.addPatient(p3);
        system.addPatient(p4);
        system.addPatient(p5);

// ===== CREATE MEDICATIONS =====
        Medication m1 = new Medication("M001", "Amoxicillin", 250, 50);
        Medication m2 = new Medication("M002", "Ibuprofen", 200, 120);
        Medication m3 = new Medication("M003", "Metformin", 500, 80);
        Medication m4 = new Medication("M004", "Atorvastatin", 10, 150);
        Medication m5 = new Medication("M005", "Ciprofloxacin", 500, 40);

        system.addMedication(m1);
        system.addMedication(m2);
        system.addMedication(m3);
        system.addMedication(m4);
        system.addMedication(m5);

// ===== CREATE PRESCRIPTIONS =====
        system.acceptPrescription("D001", "P001", "M001", LocalDate.of(2024, 10, 10));
        system.acceptPrescription("D002", "P002", "M002", LocalDate.of(2025, 3, 20));
        system.acceptPrescription("D003", "P003", "M003", LocalDate.of(2025, 1, 5));
        system.acceptPrescription("D004", "P004", "M004", LocalDate.of(2024, 8, 15));
        system.acceptPrescription("D005", "P005", "M005", LocalDate.of(2025, 7, 25));

// ===== LINK PATIENTS TO DOCTORS =====
        system.addPatientToDoctor("D001", "P001");
        system.addPatientToDoctor("D002", "P002");
        system.addPatientToDoctor("D003", "P003");
        system.addPatientToDoctor("D004", "P004");
        system.addPatientToDoctor("D005", "P005");

        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("--- Pharmacy Main Menu ---");
            System.out.println("P) Patient entry");
            System.out.println("D) Doctor entry");
            System.out.println("M) Medication search");
            System.out.println("S) Prescription search");
            System.out.println("X) Exit");
            System.out.print("Enter choice: ");
            String choice = input.nextLine().toUpperCase();

            switch (choice) {

                // ================= PATIENT MENU =================
                case "P":
                    System.out.println("\n--- Patient Menu ---");
                    System.out.println("A) Add patient");
                    System.out.println("E) Edit patient");
                    System.out.println("R) Remove patient");
                    System.out.println("V) View patient medications and doctors");
                    System.out.println("S) Search a patient by name");
                    System.out.print("Choose option: ");
                    String patientChoice = input.nextLine().toUpperCase();

                    switch (patientChoice) {
                        case "A":

                            String id = "P" + String.format("%03d", system.getPatients().size() + 1);
                            System.out.print("Enter name: ");
                            String name = input.nextLine();
                            System.out.print("Enter age: ");
                            String age = input.nextLine();
                            System.out.print("Enter phone number: ");
                            String phone = input.nextLine();
                            Patient newPatient = new Patient(id, name, age, phone);
                            system.addPatient(newPatient);
                            System.out.println("Patient added successfully.");
                            break;

                        case "E":
                            System.out.print("Enter patient ID to edit: ");
                            String editID = input.nextLine();
                            System.out.print("Enter new name (or press Enter to skip): ");
                            String newName = input.nextLine();
                            if (newName.isBlank()) {
                                newName = null;
                            }
                            System.out.print("Enter new phone number (or press Enter to skip): ");
                            String newPhone = input.nextLine();
                            if (newPhone.isBlank()) {
                                newPhone = null;
                            }
                            system.editPatient(editID, newName, newPhone);
                            break;

                        case "R":
                            System.out.print("Enter patient ID to remove: ");
                            String removeID = input.nextLine();
                            Patient toRemove = null;
                            for (Patient p : system.getPatients()) {
                                if (p.getID().equals(removeID)) {
                                    toRemove = p;
                                    break;
                                }
                            }
                            if (toRemove != null) {
                                system.deletePatient(toRemove);
                                System.out.println("Patient removed.");
                            } else {
                                System.out.println("Patient not found.");
                            }
                            break;

                        case "V":
                            System.out.print("Enter patient name: ");
                            String patientName = input.nextLine();
                            system.printPatientMedsDoctor(patientName);
                            break;

                        case "S":
                            System.out.println("Enter patient name");
                            String searchPatientName = input.nextLine();
                            System.out.println(system.searchPatientByName(searchPatientName));
                            break;

                        default:
                            System.out.println("Invalid option.");
                    }
                    break;

                // ================= DOCTOR MENU =================
                case "D":
                    System.out.println("\n--- Doctor Menu ---");
                    System.out.println("A) Add doctor");
                    System.out.println("E) Edit doctor");
                    System.out.println("P) Print doctor prescriptions");
                    System.out.println("S) Search a doctor by name");
                    System.out.print("Choose option: ");
                    String doctorChoice = input.nextLine().toUpperCase();

                    switch (doctorChoice) {
                        case "A":
                            String docID = "D" + String.format("%03d", system.getDoctors().size() + 1);
                            System.out.print("Enter name: ");
                            String docName = input.nextLine();
                            System.out.print("Enter age: ");
                            String docAge = input.nextLine();
                            System.out.print("Enter phone number: ");
                            String docPhone = input.nextLine();
                            System.out.print("Enter specialization: ");
                            String specialization = input.nextLine();
                            Doctor d = new Doctor(docID, docName, docAge, docPhone, specialization);
                            system.addDoctor(d);
                            System.out.println("Doctor added successfully.");
                            break;

                        case "E":
                            System.out.print("Enter doctor ID to edit: ");
                            String editID = input.nextLine();

                            System.out.print("Enter new name (or press Enter to skip): ");
                            String newName = input.nextLine();
                            if (newName.isBlank()) {
                                newName = null;
                            }

                            System.out.print("Enter new phone number (or press Enter to skip): ");
                            String newPhone = input.nextLine();
                            if (newPhone.isBlank()) {
                                newPhone = null;
                            }

                            System.out.print("Enter new specialization (or press Enter to skip): ");
                            String newSpecialization = input.nextLine();
                            if (newSpecialization.isBlank()) {
                                newSpecialization = null;
                            }

                            system.editDoctor(editID, newName, newPhone, newSpecialization);
                            break;

                        case "P":
                            System.out.print("Enter doctor ID: ");
                            String searchDocID = input.nextLine();
                            system.printDoctorPrescriptions(searchDocID);
                            break;

                        case "S":
                            System.out.println("Enter doctor name");
                            String searchDoctorName = input.nextLine();
                            System.out.println(system.searchDoctorByName(searchDoctorName));
                            break;

                        default:
                            System.out.println("Invalid option.");
                    }
                    break;
                // ================= MEDICATION MENU =================
                case "M":
                    System.out.println("\n--- Medication Menu ---");
                    System.out.println("A) Add new medication");
                    System.out.println("E) Edit existing medication");
                    System.out.println("R) Remove a medication");
                    System.out.println("S) Search medication by name");
                    System.out.println("C) Check for expired medications");
                    System.out.println("T) Restock all medications");
                    System.out.print("Choose option: ");
                    String medChoice = input.nextLine().toUpperCase();

                    switch (medChoice) {
                        case "A":
                            String medID = "M" + String.format("%03d", system.getMedications().size() + 1);
                            System.out.print("Enter medication name: ");
                            String medName = input.nextLine();
                            System.out.print("Enter dosage (mg): ");
                            int medDose = Integer.parseInt(input.nextLine());
                            System.out.print("Enter quantity: ");
                            int medQty = Integer.parseInt(input.nextLine());
                            Medication newMed = new Medication(medID, medName, medDose, medQty);
                            system.addMedication(newMed);
                            System.out.println("Medication added successfully.");
                            break;

                        case "E":
                            System.out.print("Enter medication ID to edit: ");
                            String editMedID = input.nextLine();

                            System.out.print("Enter new name: ");
                            String newMedName = input.nextLine();

                            System.out.print("Enter new dose (mg): ");
                            int newDose = Integer.parseInt(input.nextLine());

                            System.out.print("Enter new quantity: ");
                            int newQty = Integer.parseInt(input.nextLine());

                            System.out.print("Enter new expiry date (YYYY-MM-DD): ");
                            LocalDate newExpDate = LocalDate.parse(input.nextLine());

                            system.editMedication(editMedID, newMedName, newDose, newQty, newExpDate);
                            break;

                        case "R":
                            System.out.print("Enter medication ID to remove: ");
                            String removeMedID = input.nextLine();
                            Medication medToRemove = null;
                            for (Medication m : system.getMedications()) {
                                if (m.getID().equals(removeMedID)) {
                                    medToRemove = m;
                                    break;
                                }
                            }
                            if (medToRemove != null) {
                                system.deleteMedication(medToRemove);
                                System.out.println("Medication removed.");
                            } else {
                                System.out.println("Medication not found.");
                            }
                            break;

                        case "S":
                            System.out.print("Enter medication name: ");
                            String searchMedicationName = input.nextLine();
                            System.out.println(system.searchMedicationByName(searchMedicationName));
                            break;

                        case "C":
                            system.checkMedicationExp();
                            break;

                        case "T":
                            system.restockMeds();
                            break;

                        default:
                            System.out.println("Invalid option.");
                    }
                    break;

                // ================= PRESCRIPTION MENU =================
                case "S":
                    System.out.println("\n--- Prescription Menu ---");
                    System.out.println("A) Accept new prescription");
                    System.out.println("D) View prescriptions by doctor");
                    System.out.println("Y) View prescriptions from past year");
                    System.out.print("Choose option: ");
                    String presChoice = input.nextLine().toUpperCase();

                    switch (presChoice) {
                        case "A":
                            System.out.print("Enter doctor ID: ");
                            String doctorID = input.nextLine();
                            System.out.print("Enter patient ID: ");
                            String patientID = input.nextLine();
                            System.out.print("Enter medication ID: ");
                            String medicationID = input.nextLine();
                            System.out.print("Enter prescribe date (YYYY-MM-DD): ");
                            LocalDate prescribeDate = LocalDate.parse(input.nextLine());

                            system.acceptPrescription(doctorID, patientID, medicationID, prescribeDate);
                            break;
                        case "D":
                            System.out.print("Enter doctor ID: ");
                            String docSearch = input.nextLine();
                            system.printDoctorPrescriptions(docSearch);
                            break;

                        case "Y":
                            system.printPastYearsPrescriptions();
                            break;

                        default:
                            System.out.println("Invalid option.");
                    }
                    break;

                case "X":
                    running = false;
                    System.out.println("Exiting system... Goodbye!");
                    break;

                default:
                    System.out.println("Error: Invalid input. Please try again.");
            }
        }

        input.close();
    }
}
