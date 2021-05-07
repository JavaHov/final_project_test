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
import javax.persistence.OneToOne;

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
    @ManyToMany(mappedBy = "courses", cascade = CascadeType.PERSIST)
    private List<Teacher> teachers;
    
    private int points;
    
    public Course() {
        
    }
    
    public Course(String name) {
        
        this.name = name;
    }
    
    public Course(String name, int points) {
        
        this.name = name;
        this.points = points;
 
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        
        if(points < 0)
            this.points = 0;
        else
            this.points = points;
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
        System.out.println("ID: " + id + ", name: " + name + ", points: " + points);
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