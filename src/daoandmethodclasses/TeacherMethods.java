/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoandmethodclasses;

import java.util.Scanner;

/**
 *
 * @author Me
 */
public class TeacherMethods {
    
    
    private static Scanner scanner = new Scanner(System.in);
    private static TeacherDAO teacherDAO = new TeacherDAO();

    public static void addTeacher() {
        
        System.out.println("Name for Teacher:");
        String name = scanner.nextLine();
        teacherDAO.addTeacher(name);
    }

    public static void addCourseToTeacher() {
        
        System.out.println("Teacher ID:");
        int teacherID = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Course ID:");
        int courseID = scanner.nextInt();
        scanner.nextLine();
        
        teacherDAO.addCourseToTeacher(teacherID, courseID);
    }

    public static void updateTeacher() {
        
        System.out.println("Teacher ID:");
        int teacherID = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("New name for Teacher:");
        String newName = scanner.nextLine();
        teacherDAO.updateTeacher(teacherID, newName);
    }

    public static void removeTeacher() {
        
        System.out.println("Teacher ID:");
        int teacherID = scanner.nextInt();
        scanner.nextLine();
        
        teacherDAO.removeTeacher(teacherID);
    }

    public static void removeCourseFromTeacher() {
        
        System.out.println("Teacher ID:");
        int teacherID = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Course ID:");
        int courseID = scanner.nextInt();
        scanner.nextLine();
        
        teacherDAO.removeCourseFromTeacher(teacherID, courseID);
    }

    public static void showAllTeachers() {
        
        teacherDAO.showAllTeachers();
    }
    
}
