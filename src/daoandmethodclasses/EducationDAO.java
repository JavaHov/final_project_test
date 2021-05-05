/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoandmethodclasses;

import static daoandmethodclasses.CourseDAO.emf;
import finalprojecttest.domain.Course;
import finalprojecttest.domain.Education;
import finalprojecttest.domain.Student;
import java.util.List;
import java.util.stream.Stream;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Me
 */
public class EducationDAO {

    void addEducation(String name) {
        
        EntityManager em = emf.createEntityManager();
        
        Education education = new Education(name);
        
        em.getTransaction().begin();
        em.persist(education);
        em.getTransaction().commit();
        em.close();
    }

    void addEducationToStudent(int educationID, int studentID) {
        
        EntityManager em = emf.createEntityManager();
        
        Education education = em.find(Education.class, educationID);
        Student student = em.find(Student.class, studentID);
        
        em.getTransaction().begin();
        student.setEducation(education);
        em.getTransaction().commit();
        em.close();
    }

    void addCourseToEducation(int courseID, int educationID) {
        
        EntityManager em = emf.createEntityManager();
        
        Course course = em.find(Course.class, courseID);
        Education education = em.find(Education.class, educationID);
        
        if((course != null) && (education != null)) {
            em.getTransaction().begin();
            education.addCourse(course);
            em.getTransaction().commit();
        }
        else {
            System.out.println("No such Course or Education.");
        }
        em.close();
    }

    void updateEducation(int educationID, String newName) {
        
        EntityManager em = emf.createEntityManager();
        
        Education education = em.find(Education.class, educationID);
        
        em.getTransaction().begin();
        education.setName(newName);
        em.getTransaction().commit();
        em.close();
    }

    void removeEducation(int educationID) {
        
        EntityManager em = emf.createEntityManager();
        
        Education education = em.find(Education.class, educationID);
    
        em.getTransaction().begin();
        em.remove(education);
        em.getTransaction().commit();
        em.close();
    }

    void removeCourseFromEducation(int courseID, int educationID) {
        
        EntityManager em = emf.createEntityManager();
        
        Course course = em.find(Course.class, courseID);
        Education education = em.find(Education.class, educationID);
        
        em.getTransaction().begin();
        education.removeCourse(course);
        em.getTransaction().commit();
        em.close(); 
        
    }

    void showAllEducations() {
        
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<Education> query = em.createQuery("SELECT e FROM Education e", Education.class);
        List<Education> educations = query.getResultList();
        
        educations.forEach(e -> e.print());
        
        em.close();
        
    }

    void numberOfEducations() {
        
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<Education> query = em.createQuery("SELECT e FROM Education e", Education.class);
        List<Education> students = query.getResultList();
        
        if(students.isEmpty()) {
            
            System.out.println("No students in Table...");
        }
        else {
            
            long numEducations = students.stream().count();
            System.out.println("Number of Educations: " + numEducations);
        }
 
        em.close();
    }
    
}
