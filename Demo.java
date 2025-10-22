import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("---Pharmacy Main Menu---");
        System.out.println("P) Patient entry");
        System.out.println("D) Doctor entry");
        System.out.println("M) Medication search");
        System.out.println("S) Prescription search");
        String choice = input.nextLine().toUpperCase();

        switch (choice) {
            case "P":
                System.out.println("\n--- Patient Menu ---");
                System.out.println("A) Add patient");
                System.out.println("R) Remove patient");
                System.out.println("E) Edit patient");
                System.out.println("V) View patient details");
                System.out.print("Choose an option: ");
                String patientChoice = input.nextLine().toUpperCase();
                
                switch (patientChoice) {
                    case "A":
                        System.out.println("Adding new patient...");
                        // Add your patient creation logic here
                        break;
                    case "R":
                        System.out.println("Removing patient...");
                        // Add your patient removal logic here
                        break;
                    case "E":
                        System.out.println("Editing patient...");
                        // Add your patient editing logic here
                        break;
                    case "V":
                        System.out.println("Viewing patient details...");
                        // Add your patient viewing logic here
                        break;
                    default:
                        System.out.println("Invalid option for patient menu");
                        break;
                }
                break;
                
            case "D":
                System.out.println("\n--- Doctor Menu ---");
                System.out.println("A) Add doctor");
                System.out.println("R) Remove doctor");
                System.out.println("E) Edit doctor");
                System.out.println("V) View doctor details");
                System.out.print("Choose an option: ");
                String doctorChoice = input.nextLine().toUpperCase();
                
                switch (doctorChoice) {
                    case "A":
                        System.out.println("Adding new doctor...");
                        // Add your doctor creation logic here
                        break;
                    case "R":
                        System.out.println("Removing doctor...");
                        // Add your doctor removal logic here
                        break;
                    case "E":
                        System.out.println("Editing doctor...");
                        // Add your doctor editing logic here
                        break;
                    case "V":
                        System.out.println("Viewing doctor details...");
                        // Add your doctor viewing logic here
                        break;
                    default:
                        System.out.println("Invalid option for doctor menu");
                        break;
                }
                break;
                
            case "M":
                System.out.println("\n--- Medication Menu ---");
                System.out.println("S) Search by name");
                System.out.println("I) Search by ID");
                System.out.println("C) Search by category");
                System.out.print("Choose search type: ");
                String medicationChoice = input.nextLine().toUpperCase();
                
                switch (medicationChoice) {
                    case "S":
                        System.out.println("Searching medication by name...");
                        // Add your medication name search logic here
                        break;
                    case "I":
                        System.out.println("Searching medication by ID...");
                        // Add your medication ID search logic here
                        break;
                    case "C":
                        System.out.println("Searching medication by category...");
                        // Add your medication category search logic here
                        break;
                    default:
                        System.out.println("Invalid search option");
                        break;
                }
                break;
                
            case "S":
                System.out.println("\n--- Prescription Menu ---");
                System.out.println("P) Search by patient");
                System.out.println("D) Search by doctor");
                System.out.println("M) Search by medication");
                System.out.println("A) View all prescriptions");
                System.out.print("Choose search type: ");
                String prescriptionChoice = input.nextLine().toUpperCase();
                
                switch (prescriptionChoice) {
                    case "P":
                        System.out.println("Searching prescriptions by patient...");
                        // Add your patient prescription search logic here
                        break;
                    case "D":
                        System.out.println("Searching prescriptions by doctor...");
                        // Add your doctor prescription search logic here
                        break;
                    case "M":
                        System.out.println("Searching prescriptions by medication...");
                        // Add your medication prescription search logic here
                        break;
                    case "A":
                        System.out.println("Viewing all prescriptions...");
                        // Add your view all prescriptions logic here
                        break;
                    default:
                        System.out.println("Invalid search option");
                        break;
                }
                break;
                
            default:
                System.out.println("Error: Invalid input. Please try again");
                break;
        }
        input.close();
    }
}
