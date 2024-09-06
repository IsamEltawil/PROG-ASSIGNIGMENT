package prog.assignment;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PROGAssignment {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        boolean running = true;

        while (running) {
            try {
                System.out.println("*****************************\nSTUDENT MANAGEMENT APPLICATION\n*****************************\nEnter (1) to launch menu or any other key to exit");
                int menu = scan.nextInt();

                if (menu == 1) {
                    System.out.println("Please select one of the following menu items :\n(1) Capture a new student.\n(2) Search for a student.\n(3) Delete a student.\n(4) Print student report.\n(5) Exit Application.");
                    int choice = scan.nextInt();
                    
                    switch (choice) {
                        case 1:
                            // Capture a new student
                            captureStudent(students, scan);
                            break;
                        case 2:
                            // Search for a student
                            searchStudent(students, scan);
                            break;
                        case 3:
                            // Delete a student
                            deleteStudent(students, scan);
                            break;
                        case 4:
                            // Print student report
                            displayStudents(students);
                            break;
                        case 5:
                            System.out.println("Exiting Application!!!!");
                            running = false;
                            break;
                        default:
                            System.out.println("Invalid choice. Please select again.");
                            break;
                    }
                } else {
                    running = false;
                    System.out.println("Exiting Application!!!!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scan.next();  // Clear the invalid input
            }
        }
        
        scan.close();
    }

    // Method to capture a new student
    private static void captureStudent(ArrayList<Student> students, Scanner scan) {
        System.out.println("CAPTURE A NEW STUDENT\n**");

        System.out.println("Enter the student ID (only numbers):");
        int id = scan.nextInt();

        System.out.println("Enter the student name:");
        String name = scan.next();

        // Capture student age with validation
        int age = 0;
        boolean validAge = false;
        while (!validAge) {
            System.out.println("Enter the student age (must be 16 or older):");
            try {
                age = scan.nextInt();
                if (age >= 16) {
                    validAge = true;
                } else {
                    System.out.println("Age is invalid (less than 16 years old). Re-enter age:");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid age.");
                scan.next();  // Clear the invalid input
            }
        }

        System.out.println("Enter the student email:");
        String email = scan.next();

        System.out.println("Enter the student course:");
        String course = scan.next();

        // Create and add new student
        Student student = new Student(id, name, age, email, course);
        students.add(student);
        System.out.println("Student successfully captured!");
    }

    // Method to search for a student
    private static void searchStudent(ArrayList<Student> students, Scanner scan) {
        System.out.println("SEARCH\nEnter the Student's ID:");
        int studentID = scan.nextInt();

        boolean found = false;
        for (Student student : students) {
            if (studentID == student.getStudID()) {
                student.printStudentReport();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + studentID + " does not exist.");
        }
    }

    // Method to delete a student
    private static void deleteStudent(ArrayList<Student> students, Scanner scan) {
        System.out.println("DELETE\nEnter the Student's ID:");
        int studentID = scan.nextInt();

        boolean removed = students.removeIf(student -> student.getStudID() == studentID);
        if (removed) {
            System.out.println("Student with ID " + studentID + " has been deleted.");
        } else {
            System.out.println("Student with ID " + studentID + " does not exist.");
        }
    }

    // Method to print all student reports
    private static void displayStudents(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students captured yet.");
        } else {
            System.out.println("STUDENT REPORT\n*");
            for (Student student : students) {
                student.printStudentReport();
            }
        }
    }
    
}
