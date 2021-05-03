
package finalprojecttest;

import finalprojecttest.domain.Course;
import finalprojecttest.domain.Education;
import finalprojecttest.domain.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class FinalProjectTest {

    
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    public static void main(String[] args) {
        
        EntityManager em = emf.createEntityManager();
        
        Education education = new Education("Computer Science");
        
        Course java = new Course("Java");
        Course databases = new Course("Databases");
        
        Student student1 = new Student("Jonas");
        
        student1.setEducation(education);
        education.addCourse(java);
        education.addCourse(databases);
        
        em.getTransaction().begin();
        em.persist(student1);
        em.getTransaction().commit();
        em.close();
    }
    
}
