/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoandmethodclasses;

import static daoandmethodclasses.CourseDAO.emf;
import finalprojecttest.domain.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Me
 */
public class StudentDAO {

    void addStudent(String name) {
        
        EntityManager em = emf.createEntityManager();
        Student student = new Student(name);
        
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
        
        
    }

    void updateStudent(int studentID, String newName) {
        
        EntityManager em = emf.createEntityManager();
        
        Student student = em.find(Student.class, studentID);
        
        em.getTransaction().begin();
        student.setName(newName);
        em.getTransaction().commit();
        em.close();
    }

    void removeStudent(int studentID) {
        
        EntityManager em = emf.createEntityManager();
        Student student = em.find(Student.class, studentID);
        
        em.getTransaction().begin();
        student.removeEducation(student.getEducation());  // Testar det här då, annars blir det Violation.
        em.remove(student);
        em.getTransaction().commit();
        em.close();
    }

    void removeEducationFromStudent(int studentID, int educationID) {
        
        EntityManager em = emf.createEntityManager();
        Student student = em.find(Student.class, studentID);
        
        em.getTransaction().begin();
        student.removeEducation(student.getEducation()); // Hur blir det här?
        em.getTransaction().commit();
        em.close();
    }

    void showAllStudents() {
        
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s", Student.class);
        List<Student> students = query.getResultList();
        
        students.forEach(s -> s.print());
        em.close();
        
        
    }
    
}
