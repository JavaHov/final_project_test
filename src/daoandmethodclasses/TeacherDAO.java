/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoandmethodclasses;

import static daoandmethodclasses.CourseDAO.emf;
import finalprojecttest.domain.Course;
import finalprojecttest.domain.Teacher;
import java.util.List;
import java.util.stream.Stream;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Me
 */
public class TeacherDAO {

    void addTeacher(String name, int age) {
        
        EntityManager em = emf.createEntityManager();
        Teacher teacher = new Teacher(name, age);
        
        em.getTransaction().begin();
        em.persist(teacher);
        em.getTransaction().commit();
        em.close();
    }

    void updateTeacher(int teacherID, String newName, int newAge) {
        
        EntityManager em = emf.createEntityManager();
        Teacher teacher = em.find(Teacher.class, teacherID);
        
        em.getTransaction().begin();
        teacher.setName(newName);
        teacher.setAge(newAge);
        em.getTransaction().commit();
        em.close();
    }

    void removeTeacher(int teacherID) {
        
        EntityManager em = emf.createEntityManager();
        Teacher teacher = em.find(Teacher.class, teacherID);
        
        em.getTransaction().begin();
        em.remove(teacher);
        em.getTransaction().commit();
        em.close();
    }

    void addCourseToTeacher(int teacherID, int courseID) {
        
        EntityManager em = emf.createEntityManager();
        Teacher teacher = em.find(Teacher.class, teacherID);
        Course course = em.find(Course.class, courseID);
        
        em.getTransaction().begin();
        teacher.addCourse(course);
        em.getTransaction().commit();
        em.close();
    }

    void removeCourseFromTeacher(int teacherID, int courseID) {
        
        EntityManager em = emf.createEntityManager();
        Teacher teacher = em.find(Teacher.class, teacherID);
        Course course = em.find(Course.class, courseID);
        
        em.getTransaction().begin();
        teacher.removeCourse(course);
        em.getTransaction().commit();
        em.close();
    }

    void showAllTeachers() {
        
        EntityManager em = emf.createEntityManager();
        TypedQuery<Teacher> query = em.createQuery("SELECT t FROM Teacher t", Teacher.class);
        
        List<Teacher> teachers = query.getResultList();
        teachers.forEach(t -> t.print());

        em.close();
    }

    void numberOfTeachers() {
        
        EntityManager em = emf.createEntityManager();
        TypedQuery<Teacher> query = em.createQuery("SELECT t FROM Teacher t", Teacher.class);
        
        List<Teacher> teachers = query.getResultList();
        
        long numTeachers = teachers.stream().count();
        
        System.out.println("Number of Teachers: " + numTeachers);
        
        em.close();
    }

    void averageAgeTeachers() {
        
        EntityManager em = emf.createEntityManager();
        TypedQuery<Teacher> query = em.createQuery("SELECT t FROM Teacher t", Teacher.class);
        
        List<Teacher> teachers = query.getResultList();
        
        if(teachers.isEmpty()) {
            
            System.out.println("No Teachers in Table...");
        }
        else {
            
            double averageAge = teachers.stream().mapToInt(t -> t.getAge()).average().getAsDouble();
            System.out.format("Average age Teachers: %.2f years.", averageAge);
            System.out.println();
        }

        em.close();
    }
    
}
