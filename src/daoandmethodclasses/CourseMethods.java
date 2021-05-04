
package daoandmethodclasses;

import java.util.Scanner;


public class CourseMethods {
    
    private static Scanner scanner = new Scanner(System.in);
    private static CourseDAO courseDAO = new CourseDAO();

    public static void addCourse() {
        
        System.out.println("Testing... in addCourse...");
        System.out.println("Name of Course:");
        String name = scanner.nextLine();
        courseDAO.addCourse(name);
        
    }

    public static void updateCourse() {
        
        System.out.println("Course ID:");
        int courseID = scanner.nextInt();
        scanner.nextLine();
        
        
        System.out.println("New name of Course:");
        String newName = scanner.nextLine();
        courseDAO.updateCourse(courseID, newName);
    }

    public static void removeCourse() {
        
        System.out.println("Course ID:");
        int courseId = scanner.nextInt();
        scanner.nextLine();
        courseDAO.removeCourse(courseId);
    }

    public static void showAllCourses() {
        
        courseDAO.showAllCourses();
    }

    public static void addTeacherToCourse() {
        
        System.out.println("Teacher ID:");
        int teacherID = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Course ID");
        int courseID = scanner.nextInt();
        scanner.nextLine();
        courseDAO.addTeacherToCourse(teacherID, courseID);
    }
    
}
