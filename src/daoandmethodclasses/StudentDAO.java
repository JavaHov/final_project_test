/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoandmethodclasses;

import static daoandmethodclasses.CourseDAO.emf;
import finalprojecttest.domain.Education;
import finalprojecttest.domain.Student;
import java.util.List;
import java.util.OptionalDouble;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Me
 */
public class StudentDAO {

    void addStudent(String name, int age) {
        
        EntityManager em = emf.createEntityManager();
        Student student = new Student(name, age);
        
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
        
        
    }

    void updateStudent(int studentID, String newName, int newAge) {
        
        EntityManager em = emf.createEntityManager();
        
        Student student = em.find(Student.class, studentID);
        
        em.getTransaction().begin();
        student.setName(newName);
        student.setAge(newAge);
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

    void numberOfStudents() {
        
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s", Student.class);
        List<Student> students = query.getResultList();
        
        long numStudents = students.stream().count();
        
        System.out.println("Number of Students: " + numStudents);
        
        em.close();
    }

    void averageAgeStudents() {
        
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s", Student.class);
        List<Student> students = query.getResultList();
        
        if(students.isEmpty()) {
            
            System.out.println("No students in Table...");
        }
        else {
            
            double averageAge = students.stream().mapToInt(s -> s.getAge()).average().getAsDouble();
            System.out.format("Average age Students: %.2f years.", averageAge);
            System.out.println();
        }

        em.close();
        
    }

    void addNewStudentToNewEducation(String studName, int studAge, String eduName) {
        
        EntityManager em = emf.createEntityManager();
        
        Student student = new Student(studName, studAge);
        Education education = new Education(eduName);
        
        student.setEducation(education);
        
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    void youngestStudent() {
        
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s", Student.class);
        List<Student> students = query.getResultList();
        
        int youngest = students.stream().mapToInt(s -> s.getAge()).min().getAsInt();
        
        System.out.println("The youngest Student(s):");
        students.stream().filter(s -> s.getAge() == youngest).forEach(s -> s.print());
    }

    void oldestStudent() {
        
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s", Student.class);
        List<Student> students = query.getResultList();
        
        int oldest = students.stream().mapToInt(Student::getAge).max().getAsInt();
        
        System.out.println("The oldest Student(s):");
        students.stream().filter(s -> s.getAge() == oldest).forEach(s -> s.print());
    }
    
}
