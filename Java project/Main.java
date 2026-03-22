import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StudentManager manager = new StudentManager();
        manager.loadData();

        Scanner sc = new Scanner(System.in);
        int choice = -1;

        while (choice != 9) {
            System.out.println("\n===== STUDENT ENROLLMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Enroll Subject");
            System.out.println("3. Drop Subject");
            System.out.println("4. Display Student Details");
            System.out.println("5. Search Student");
            System.out.println("6. Sort Students");
            System.out.println("7. Delete Student");
            System.out.println("8. List Students & View Details");
            System.out.println("9. Save & Exit");
            System.out.print("Choose > ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> manager.addStudentConsole();
                case 2 -> manager.enrollSubjectConsole();
                case 3 -> manager.dropSubjectConsole();
                case 4 -> manager.displayStudentConsole();
                case 5 -> manager.searchStudentConsole();
                case 6 -> manager.sortStudentsConsole();
                case 7 -> manager.deleteStudentConsole();
                case 8 -> manager.listStudentsAndViewDetails();
                case 9 -> {
                    manager.saveData();
                    System.out.println("Saved. Exiting...");
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
