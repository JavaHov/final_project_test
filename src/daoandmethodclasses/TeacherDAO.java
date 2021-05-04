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
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Me
 */
public class TeacherDAO {

    void addTeacher(String name) {
        
        EntityManager em = emf.createEntityManager();
        Teacher teacher = new Teacher(name);
        
        em.getTransaction().begin();
        em.persist(teacher);
        em.getTransaction().commit();
        em.close();
    }

    void updateTeacher(int teacherID, String newName) {
        
        EntityManager em = emf.createEntityManager();
        Teacher teacher = em.find(Teacher.class, teacherID);
        
        em.getTransaction().begin();
        teacher.setName(newName);
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
    
}
