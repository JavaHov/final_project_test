
package finalprojecttest;

import daoandmethodclasses.CourseDAO;
import daoandmethodclasses.CourseMethods;
import daoandmethodclasses.EducationMethods;
import daoandmethodclasses.StudentMethods;
import daoandmethodclasses.TeacherMethods;
import java.util.InputMismatchException;
import java.util.Scanner;


public class MainTestProgram {
    
    static boolean loop = true;
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        while(loop) {
            
            switchChoice(mainMenu());
        }

    } 
    
    
    public static int mainMenu() {
        
        System.out.println("--------------------");
        System.out.println("1. Add menu");
        System.out.println("2. Update menu");
        System.out.println("3. Remove menu");
        System.out.println("4. Print menu");
        System.out.println("5. Statistics menu");
        System.out.println("0. Exit");
        System.out.println("---------------------");
        
        int choice = getCheckedInt();
        
        return choice;
    }

    private static void switchChoice(int choice) {
        
        switch(choice) {
            
            case 1:
                addItem();
                break;
            case 2:
                updateItem();
                break;
            case 3:
                removeItem();
                break;
            case 4:
                print();
                break;
            case 5:
                statistics();
                break;
            case 0:
                loop = false;
                CourseDAO.emf.close();
                break;
            default:
                System.out.println("Invalid choice, try again");
                break;
        }
    }

    private static void addItem() {
        
        System.out.println("-------------------------------");
        System.out.println("1. Add Student");
        System.out.println("2. Add Course");
        System.out.println("3. Add Education");
        System.out.println("4. Add Teacher");
        System.out.println("5. Add Education to Student");
        System.out.println("6. Add Course to Education");
        System.out.println("7. Add Course to Teacher");
        System.out.println("8. Add Teacher to Course");
        System.out.println("9. Add new Student to new Education");
        System.out.println("-------------------------------");
        
        int choice = getCheckedInt();
        
        switch(choice) {
            
            case 1:
                StudentMethods.addStudent();
                break;
            case 2:
                CourseMethods.addCourse();
                break;
            case 3:
                EducationMethods.addEducation();
                break;
            case 4:
                TeacherMethods.addTeacher();
                break;
            case 5:
                EducationMethods.addEducationToStudent();
                break;
            case 6:
                EducationMethods.addCourseToEducation();
                break;
            case 7:
                TeacherMethods.addCourseToTeacher();
                break;
            case 8:
                CourseMethods.addTeacherToCourse();
                break;
            case 9:
                StudentMethods.addNewStudentToNewEducation();
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private static void updateItem() {
        
        System.out.println("-------------------------");
        System.out.println("1. Update Student");
        System.out.println("2. Update Course");
        System.out.println("3. Update Education");
        System.out.println("4. Update Teacher");
        System.out.println("--------------------------");
        
        int choice = getCheckedInt();
        
        switch(choice) {
            
            case 1:
                StudentMethods.updateStudent();
                break;
            case 2:
                CourseMethods.updateCourse();
                break;
            case 3:
                EducationMethods.updateEducation();
                break;
            case 4:
                TeacherMethods.updateTeacher();
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private static void removeItem() {
        
        System.out.println("----------------------------------");
        System.out.println("1. Remove Student");
        System.out.println("2. Remove Course");
        System.out.println("3. Remove Education");
        System.out.println("4. Remove Teacher");
        System.out.println("5. Remove Course from Education");
        System.out.println("6. Remove Education from Student");
        System.out.println("7. Remove Course from Teacher");
        System.out.println("-----------------------------------");
        
        int choice = getCheckedInt();
        
        switch(choice) {
            
            case 1:
                StudentMethods.removeStudent();
                break;
            case 2:
                CourseMethods.removeCourse();
                break;
            case 3:
                EducationMethods.removeEducation();
                break;
            case 4:
                TeacherMethods.removeTeacher();
                break;
            case 5:
                EducationMethods.removeCourseFromEducation();
                break;
            case 6:
                StudentMethods.removeEducationFromStudent();
                break;
            case 7:
                TeacherMethods.removeCourseFromTeacher();
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private static void print() {
        
        System.out.println("--------------------------");
        System.out.println("1. Show all Students");
        System.out.println("2. Show all Courses");
        System.out.println("3. Show all Educations");
        System.out.println("4. Show all Teachers");
        System.out.println("---------------------------");
        
        int choice = getCheckedInt();
        
        switch(choice) {
            
            case 1:
                StudentMethods.showAllStudents();
                break;
            case 2:
                CourseMethods.showAllCourses();
                break;
            case 3:
                EducationMethods.showAllEducations();
                break;
            case 4:
                TeacherMethods.showAllTeachers();
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private static void statistics() {
        
        System.out.println("1. Number of Students");
        System.out.println("2. Number of Teachers");
        System.out.println("3. Number of Courses");
        System.out.println("4. Number of Educations");
        System.out.println("5. Average age Students");
        System.out.println("6. Average age Teachers");
        System.out.println("7. Youngest Student");
        System.out.println("8. Oldest Student");
        System.out.println("9. Youngest Teacher");
        System.out.println("10. Oldest Teacher");
        
        int choice = getCheckedInt();
        
        switch(choice) {
            
            case 1:
                StudentMethods.numberOfStudents();
                break;
            case 2:
                TeacherMethods.numberOfTeachers();
                break;
            case 3:
                CourseMethods.numberOfCourses();
                break;
            case 4:
                EducationMethods.numberOfEducations();
                break;
            case 5:
                StudentMethods.averageAgeStudents();
                break;
            case 6:
                TeacherMethods.averageAgeTeachers();
                break;
            case 7:
                StudentMethods.youngestStudent();
                break;
            case 8:
                StudentMethods.oldestStudent();
                break;
            case 9:
                TeacherMethods.youngestTeacher();
                break;
            case 10:
                TeacherMethods.oldestTeacher();
                break;
            default:
                break;
        }
    }
    
    
    public static int getCheckedInt() {
        
        int choice = 0;
        boolean loop = true;
        
        while(loop) {
            try {
               choice = scanner.nextInt();
               scanner.nextLine();
               loop = false;
            }
            catch(InputMismatchException e) {
                System.out.println("Only numbers: Try again.");
                scanner.nextLine();
            }   
        }
        return choice;
        
    }
}
