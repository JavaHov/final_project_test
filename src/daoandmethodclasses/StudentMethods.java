
package daoandmethodclasses;

import static daoandmethodclasses.EducationMethods.showAllEducations;
import static finalprojecttest.MainTestProgram.getCheckedInt;
import java.util.Scanner;


public class StudentMethods {
    
    private static Scanner scanner = new Scanner(System.in);
    private static StudentDAO studentDAO = new StudentDAO();

    public static void addStudent() {
        
        System.out.println("Name of Student:");
        String name = scanner.nextLine();
        
        System.out.println("Age:");
        int age = getCheckedInt();
        studentDAO.addStudent(name, age);
    }

    public static void updateStudent() {

        showAllStudents();
        System.out.println("Studen ID:");
        int studentID = getCheckedInt();
        
        System.out.println("New name of Student:");
        String newName = scanner.nextLine();
        
        System.out.println("New age of Student:");
        int newAge = getCheckedInt();
        studentDAO.updateStudent(studentID, newName, newAge);        
        
    }

    public static void removeStudent() {
        
        showAllStudents();
        System.out.println("Student ID:");
        int studentID = getCheckedInt();
        studentDAO.removeStudent(studentID);
    }

    public static void removeEducationFromStudent() {
        
        showAllStudents();
        System.out.println("Student ID:");
        int studentID = getCheckedInt();
        
        showAllEducations();
        System.out.println("Education ID:");
        int educationID = getCheckedInt();
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

    public static void addNewStudentToNewEducation() {
        
        System.out.println("Name of new Student:");
        String studName = scanner.nextLine();
        
        System.out.println("Age of Student:");
        int studAge = getCheckedInt();
        
        System.out.println("Name of new Education:");
        String eduName = scanner.nextLine();
        studentDAO.addNewStudentToNewEducation(studName, studAge, eduName);
    }

    public static void youngestStudent() {
        
        studentDAO.youngestStudent();
    }

    public static void oldestStudent() {
        
        studentDAO.oldestStudent();
    }
    
}
