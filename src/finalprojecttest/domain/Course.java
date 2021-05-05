package finalprojecttest.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * @author Me
 */
@Entity
@Cacheable(false)
public class Course {

    @Id
    @GeneratedValue
    private int id;
    @Basic
    private String name;
    @ManyToOne
    private Education education;
    @ManyToMany(mappedBy = "courses")
    private List<Teacher> teachers;
    
    public Course() {
        
    }
    
    public Course(String name) {
        
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public List<Teacher> getTeachers() {
        if (teachers == null) {
            teachers = new ArrayList<>();
        }
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void addTeacher(Teacher teacher) {
        getTeachers().add(teacher);
    }

    public void removeTeacher(Teacher teacher) {
        getTeachers().remove(teacher);
    }

    public void print() {
        
        System.out.println("--------- Course ------------------------");
        System.out.println("ID: " + id + " name: " + name);
        if(education == null)
            System.out.println("(no registered education)");
        else
            System.out.println("Belongs to education:" + education.getName());
        System.out.println("Teacher/s: ");
        
        if(teachers == null)
            System.out.println("(no registered teachers)");
        else
            teachers.forEach(t -> System.out.println(t.getName()));
        System.out.println("-----------------------------------------");
        
    }
    
    

}