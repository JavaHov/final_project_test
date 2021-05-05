
package daoandmethodclasses;

import finalprojecttest.domain.Course;
import finalprojecttest.domain.Teacher;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class CourseDAO {
    
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    void addCourse(String name) {
        
        EntityManager em = emf.createEntityManager();
        
        Course c = new Course(name);
        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        
        
    }

    void updateCourse(int courseID, String newName) {
        
        EntityManager em = emf.createEntityManager();
        Course course = em.find(Course.class, courseID);
        
        em.getTransaction().begin();
        course.setName(newName);
        em.getTransaction().commit();
        em.close();
        

    }

    void removeCourse(int courseID) {
        
        EntityManager em = emf.createEntityManager();
        Course course = em.find(Course.class, courseID);
        
        em.getTransaction().begin();
        em.remove(course);
        em.getTransaction().commit();
        em.close();
    }

    void showAllCourses() {
        
       EntityManager em = emf.createEntityManager();
       
       TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c", Course.class);
       List<Course> courses = query.getResultList();
       
       courses.forEach(c -> c.print());
       
       em.close();
    }

    void addTeacherToCourse(int teacherID, int courseID) {
        
        EntityManager em = emf.createEntityManager();
        
        Course course = em.find(Course.class, courseID);
        Teacher teacher = em.find(Teacher.class, teacherID);
        
        em.getTransaction().begin();
        course.addTeacher(teacher);
        em.getTransaction().commit();
        em.close();
    }

    void numberOfCourses() {
        
       EntityManager em = emf.createEntityManager();
       
       TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c", Course.class);
       List<Course> courses = query.getResultList();
       
       if(courses.isEmpty()) {
           System.out.println("No Courses...");
       }
       else {
           
            long numCourses = courses.stream().count();
            System.out.println("Number of Courses: " + numCourses);  
       }

        em.close();
    }
    
}
