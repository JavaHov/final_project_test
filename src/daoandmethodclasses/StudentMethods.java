
package daoandmethodclasses;

import java.util.Scanner;


public class StudentMethods {
    
    private static Scanner scanner = new Scanner(System.in);
    private static StudentDAO studentDAO = new StudentDAO();

    public static void addStudent() {
        
        System.out.println("Name of Student:");
        String name = scanner.nextLine();
        
        System.out.println("Age:");
        int age = scanner.nextInt();
        scanner.nextLine();
        studentDAO.addStudent(name, age);
    }

    public static void updateStudent() {

        System.out.println("Studen ID:");
        int studentID = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("New name of Student:");
        String newName = scanner.nextLine();
        
        System.out.println("New age of Student:");
        int newAge = scanner.nextInt();
        scanner.nextLine();
        studentDAO.updateStudent(studentID, newName, newAge);        
        
    }

    public static void removeStudent() {
        
        System.out.println("Student ID:");
        int studentID = scanner.nextInt();
        scanner.nextLine();
        studentDAO.removeStudent(studentID);
    }

    public static void removeEducationFromStudent() {
        
        System.out.println("Student ID:");
        int studentID = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Education ID:");
        int educationID = scanner.nextInt();
        scanner.nextLine();
        studentDAO.removeEducationFromStudent(studentID, educationID);
    }

    public static void showAllStudents() {
        
        studentDAO.showAllStudents();
    }

    public static void numberOfStudents() {
        
        studentDAO.numberOfStudents();
    }

    public static void averageAgeStudents() {
        
        studentDAO.averageAgeStudents();
    }
    
}
