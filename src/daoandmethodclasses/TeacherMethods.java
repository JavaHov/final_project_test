/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoandmethodclasses;

import static daoandmethodclasses.CourseMethods.showAllCourses;
import static finalprojecttest.MainTestProgram.getCheckedInt;
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
        
        System.out.println("Age:");
        int age = getCheckedInt();
        
        teacherDAO.addTeacher(name, age);
    }

    public static void addCourseToTeacher() {
        
        showAllTeachers();
        System.out.println("Teacher ID:");
        int teacherID = getCheckedInt();
        
        showAllCourses();
        System.out.println("Course ID:");
        int courseID = getCheckedInt();
        
        teacherDAO.addCourseToTeacher(teacherID, courseID);
    }

    public static void updateTeacher() {
        
        showAllTeachers();
        System.out.println("Teacher ID:");
        int teacherID = getCheckedInt();
        
        System.out.println("New name for Teacher:");
        String newName = scanner.nextLine();
        
        System.out.println("New age for Teacher:");
        int newAge = getCheckedInt();
        teacherDAO.updateTeacher(teacherID, newName, newAge);
    }

    public static void removeTeacher() {
        
        showAllTeachers();
        System.out.println("Teacher ID:");
        int teacherID = getCheckedInt();
        
        teacherDAO.removeTeacher(teacherID);
    }

    public static void removeCourseFromTeacher() {
        
        showAllTeachers();
        System.out.println("Teacher ID:");
        int teacherID = getCheckedInt();
        
        showAllCourses();
        System.out.println("Course ID:");
        int courseID = getCheckedInt();
        
        teacherDAO.removeCourseFromTeacher(teacherID, courseID);
    }

    public static void showAllTeachers() {
        
        teacherDAO.showAllTeachers();
    }

    public static void numberOfTeachers() {
        
        teacherDAO.numberOfTeachers();
    }

    public static void averageAgeTeachers() {
        
        teacherDAO.averageAgeTeachers();
    }

    public static void youngestTeacher() {
        
        teacherDAO.youngestTeacher();
    }

    public static void oldestTeacher() {
        
        teacherDAO.oldestTeacher();
    }
    
}
