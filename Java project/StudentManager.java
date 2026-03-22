import java.io.*;
import java.util.*;

public class StudentManager {

    private Student[] students = new Student[100];
    private int count = 0;

    //load student.txt 
    public void loadData() {
        try {
            File file = new File("Student.txt");
            if (!file.exists()) return;

            Scanner sc = new Scanner(file);
            Student current = null;

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                if (line.contains(",")) {
                    String[] parts = line.split(",");
                    if (parts[0].matches("\\d+")) {
                        current = new Student(parts[0], parts[1]);
                        students[count++] = current;
                    } else {
                        current.getSubjects().insert(parts[0], parts[1]);
                    }
                }
            }
            sc.close();

        } catch (Exception e) {
            System.out.println("Error loading file.");
        }
    }

    //data details student masuk ke student.txt
    public void saveData() {
        try {
            PrintWriter writer = new PrintWriter("Student.txt");

            for (int i = 0; i < count; i++) {
                Student s = students[i];
                writer.println(s.getID() + "," + s.getName());
                writer.print(s.getSubjects().displayForFile());
                writer.println();
            }

            writer.close();
        } catch (Exception e) {
            System.out.println("Error saving file.");
        }
    }

    //add new student details
    public void addStudentConsole() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        students[count++] = new Student(id, name);
        System.out.println("Student added.");
    }

    //add subject
    public void enrollSubjectConsole() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        Student s = search(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter Subject Code: ");
        String code = sc.nextLine();

        System.out.print("Enter Subject Name: ");
        String name = sc.nextLine();

        s.getSubjects().insert(code, name);
        System.out.println("Subject added.");
    }

    //drop student id
    public void dropSubjectConsole() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        Student s = search(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter Subject Code to remove: ");
        String code = sc.nextLine();

        s.getSubjects().remove(code);
        System.out.println("Subject removed.");
    }

    //display student dengan id
    public void displayStudentConsole() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        Student s = search(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("\n" + s.getID() + " - " + s.getName());
        System.out.println("Subjects:");
        System.out.println(s.getSubjects().display());
    }

    //search student guna id
    public void searchStudentConsole() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name or ID: ");
        String key = sc.nextLine();

        Student s = search(key);
        if (s == null) System.out.println("Not found.");
        else System.out.println("Found: " + s.getID() + " - " + s.getName());
    }

    //sort student
    public void sortStudentsConsole() {
        Arrays.sort(students, 0, count, Comparator.comparing(Student::getID));
        System.out.println("Students sorted by ID.");
    }

    //delete stdent
    public void deleteStudentConsole() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        for (int i = 0; i < count; i++) {
            if (students[i].getID().equals(id)) {

                students[i].getSubjects().clear();

                for (int j = i; j < count - 1; j++)
                    students[j] = students[j + 1];

                count--;

                System.out.println("Student deleted.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    //search studente
    private Student search(String key) {
        for (int i = 0; i < count; i++) {
            if (students[i].getID().equalsIgnoreCase(key) ||
                students[i].getName().equalsIgnoreCase(key)) {
                return students[i];
            }
        }
        return null;
    }
    //ini untuk case 8 yang main
    public void listStudentsAndViewDetails() {
    if (count == 0) {
        System.out.println("No students available.");
        return;
    }

    // Show all students
    System.out.println("\n===== LIST OF STUDENTS =====");
    for (int i = 0; i < count; i++) {
        System.out.println((i + 1) + ". " + students[i].getID() + " - " + students[i].getName());
    }

    // Let user choose a student by the senarai
    Scanner sc = new Scanner(System.in);
    System.out.print("\nSelect number to view details: ");
    String input = sc.nextLine();

    // Validate input
    try {
        int index = Integer.parseInt(input) - 1;

        if (index < 0 || index >= count) {
            System.out.println("Invalid choice.");
            return;
        }

        Student s = students[index];

        // Display student details,if ada details dlm student.txt saved data
        System.out.println("\n===== STUDENT DETAILS =====");
        System.out.println("ID: " + s.getID());
        System.out.println("Name: " + s.getName());
        System.out.println("\nEnrolled Subjects:");
        String subjects = s.getSubjects().display();
        System.out.println(subjects.isEmpty() ? "(No subjects enrolled)" : subjects);

    } catch (NumberFormatException e) {
        System.out.println("Invalid input. Must be a number.");
    }
   }
}



