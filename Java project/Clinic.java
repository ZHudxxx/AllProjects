import java.util.Scanner;

class Patient {
    String name;
    String patientId;
    String bloodType;
    double bodyTemperature;
    double bloodPressure;
    Patient next;

    public Patient(String name, String patientId, String bloodType, double bodyTemperature, double bloodPressure) {
        this.name = name;
        this.patientId = patientId;
        this.bloodType = bloodType;
        this.bodyTemperature = bodyTemperature;
        this.bloodPressure = bloodPressure;
        this.next = null;
    }
}

class PatientList {
    private Patient head;
    private int size;

    public PatientList() {
        this.head = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void addPatient(String name, String patientId, String bloodType, double bodyTemperature, double bloodPressure) {
        Patient newPatient = new Patient(name, patientId, bloodType, bodyTemperature, bloodPressure);
        if (head == null) {
            head = newPatient;
        } else {
            Patient current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newPatient;
        }
        size++;
    }

    public Patient searchPatient(String patientId) {
        Patient current = head;
        while (current != null) {
            if (current.patientId.equals(patientId)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void display() {
        Patient current = head;
        while (current != null) {
            System.out.println("Patient ID: " + current.patientId + ", Name: " + current.name);
            current = current.next;
        }
    }
}

public class Clinic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PatientList patientList = new PatientList();

        while (true) {
            System.out.println("1. Add Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Display Patients");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter patient ID: ");
                    String patientId = scanner.nextLine();
                    System.out.print("Enter blood type: ");
                    String bloodType = scanner.nextLine();
                    System.out.print("Enter body temperature: ");
                    double bodyTemperature = scanner.nextDouble();
                    System.out.print("Enter blood pressure: ");
                    double bloodPressure = scanner.nextDouble();
                    patientList.addPatient(name, patientId, bloodType, bodyTemperature, bloodPressure);
                    break;
                case 2:
                    System.out.print("Enter patient ID to search: ");
                    patientId = scanner.nextLine();
                    Patient patient = patientList.searchPatient(patientId);
                    if (patient != null) {
                        System.out.println("Patient ID: " + patient.patientId + ", Name: " + patient.name +
                                ", Blood Type: " + patient.bloodType +
                                ", Body Temperature: " + patient.bodyTemperature +
                                ", Blood Pressure: " + patient.bloodPressure);
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;
                case 3:
                    patientList.display();
                    break;
                case 4:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }
}