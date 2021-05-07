
package finalprojecttest;

import finalprojecttest.domain.Course;
import finalprojecttest.domain.Education;
import finalprojecttest.domain.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class FinalProjectTest {

    
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    public static void main(String[] args) {
        
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s", Student.class);
        List<Student> students = query.getResultList();
        
        int youngest = students.stream().mapToInt(s -> s.getAge()).min().getAsInt();
        
        System.out.println("The youngest student/s: ");
        students.stream().filter(s -> s.getAge() == youngest).forEach(s -> s.print());
        
        
        int oldest = students.stream().mapToInt(s -> s.getAge()).max().getAsInt();
        
        System.out.println("Oldest student/s:");
        students.stream().filter(s -> s.getAge() == oldest).forEach(s -> s.print());
        
        em.close();
    }
    
}
