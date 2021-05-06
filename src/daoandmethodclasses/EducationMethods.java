/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoandmethodclasses;

import static daoandmethodclasses.CourseMethods.showAllCourses;
import static daoandmethodclasses.StudentMethods.showAllStudents;
import static finalprojecttest.MainTestProgram.getCheckedInt;
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
        
        showAllEducations();
        System.out.println("Education ID:");
        int educationID = getCheckedInt();
        
        showAllStudents();
        System.out.println("Student ID:");
        int studentID = getCheckedInt();
        
        educationDAO.addEducationToStudent(educationID, studentID);
    }

    public static void addCourseToEducation() {
        
        showAllCourses();
        System.out.println("Course ID:");
        int courseID = getCheckedInt();
        
        showAllEducations();
        System.out.println("Education ID:");
        int educationID = getCheckedInt();
        
        educationDAO.addCourseToEducation(courseID, educationID);
    }

    public static void updateEducation() {
        
        showAllEducations();
        System.out.println("Education ID:");
        int educationID = getCheckedInt();
        
        System.out.println("New name for Education:");
        String newName = scanner.nextLine();
        educationDAO.updateEducation(educationID, newName);
    }

    public static void removeEducation() {
        
        showAllEducations();
        System.out.println("Education ID:");
        int educationID = getCheckedInt();
        educationDAO.removeEducation(educationID);
    }

    public static void removeCourseFromEducation() {
        
        showAllCourses();
        System.out.println("Course ID:");
        int courseID = getCheckedInt();
        
        showAllEducations();
        System.out.println("Education ID:");
        int educationID = getCheckedInt();
        educationDAO.removeCourseFromEducation(courseID, educationID);
    }

    public static void showAllEducations() {
        
        educationDAO.showAllEducations();
    }

    public static void numberOfEducations() {
        
        educationDAO.numberOfEducations();
    }
    
}
