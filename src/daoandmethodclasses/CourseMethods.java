
package daoandmethodclasses;

import static daoandmethodclasses.TeacherMethods.showAllTeachers;
import static finalprojecttest.MainTestProgram.getCheckedInt;
import java.util.Scanner;


public class CourseMethods {
    
    private static Scanner scanner = new Scanner(System.in);
    private static CourseDAO courseDAO = new CourseDAO();

    public static void addCourse() {
        
        System.out.println("Name of Course:");
        String name = scanner.nextLine();
        
        System.out.println("Points for Course:");
        int points = getCheckedInt();
        
        courseDAO.addCourse(name, points);
        
    }

    public static void updateCourse() {
        
        showAllCourses();
        System.out.println("Course ID:");
        int courseID = getCheckedInt();
        
        
        System.out.println("New name of Course:");
        String newName = scanner.nextLine();
        
        System.out.println("Points for Course:");
        int newPoints = getCheckedInt();
        
        courseDAO.updateCourse(courseID, newName, newPoints);
    }

    public static void removeCourse() {
        
        showAllCourses();
        System.out.println("Course ID:");
        int courseId = getCheckedInt();
        courseDAO.removeCourse(courseId);
    }

    public static void showAllCourses() {
        
        courseDAO.showAllCourses();
    }

    public static void addTeacherToCourse() {
        
        showAllTeachers();
        System.out.println("Teacher ID:");
        int teacherID = getCheckedInt();
        
        showAllCourses();
        System.out.println("Course ID");
        int courseID = getCheckedInt();
        courseDAO.addTeacherToCourse(teacherID, courseID);
    }

    public static void numberOfCourses() {
        
        courseDAO.numberOfCourses();
    }
    
}
