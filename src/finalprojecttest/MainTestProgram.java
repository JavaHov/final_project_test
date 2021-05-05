
package finalprojecttest;

import daoandmethodclasses.CourseDAO;
import daoandmethodclasses.CourseMethods;
import daoandmethodclasses.EducationMethods;
import daoandmethodclasses.StudentMethods;
import daoandmethodclasses.TeacherMethods;
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
        System.out.println("1. Add item");
        System.out.println("2. Update item");
        System.out.println("3. Remove item");
        System.out.println("4. Print");
        System.out.println("5. Statistics");
        System.out.println("0. Exit");
        System.out.println("---------------------");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
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
        System.out.println("-------------------------------");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
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
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
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
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
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
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
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
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
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
            default:
                break;
        }
    }
}
