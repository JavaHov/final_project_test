/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoandmethodclasses;

import java.util.Scanner;


public class EducationMethods {
    
    
    private static Scanner scanner = new Scanner(System.in);
    private static EducationDAO educationDAO = new EducationDAO();

    public static void addEducation() {
        
        System.out.println("Name of Education:");
        String name = scanner.nextLine();
        educationDAO.addEducation(name);
    }

    public static void addEducationToStudent() {
        
        System.out.println("Education ID:");
        int educationID = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Student ID:");
        int studentID = scanner.nextInt();
        scanner.nextLine();
        
        educationDAO.addEducationToStudent(educationID, studentID);
    }

    public static void addCourseToEducation() {
        
        System.out.println("Course ID:");
        int courseID = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Education ID:");
        int educationID = scanner.nextInt();
        scanner.nextLine();
        
        educationDAO.addCourseToEducation(courseID, educationID);
    }

    public static void updateEducation() {
        
        System.out.println("Education ID:");
        int educationID = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("New name for Education:");
        String newName = scanner.nextLine();
        educationDAO.updateEducation(educationID, newName);
    }

    public static void removeEducation() {
        
        System.out.println("Education ID:");
        int educationID = scanner.nextInt();
        scanner.nextLine();
        educationDAO.removeEducation(educationID);
    }

    public static void removeCourseFromEducation() {
        
        System.out.println("Course ID:");
        int courseID = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Education ID:");
        int educationID = scanner.nextInt();
        scanner.nextLine();
        educationDAO.removeCourseFromEducation(courseID, educationID);
    }

    public static void showAllEducations() {
        
        educationDAO.showAllEducations();
    }

    public static void numberOfEducations() {
        
        educationDAO.numberOfEducations();
    }
    
}
