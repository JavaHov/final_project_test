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

/**
 * @author Me
 */
@Entity
@Cacheable(false)
public class Teacher {

    @Id
    @GeneratedValue
    private int id;
    @Basic
    private String name;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Course> courses;

    public Teacher() {
        
    }
    
    public Teacher(String name) {
        
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

    public List<Course> getCourses() {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        getCourses().add(course);
        course.getTeachers().add(this);
    }

    public void removeCourse(Course course) {
        getCourses().remove(course);
        course.getTeachers().remove(this);
    }

    public void print() {
        
        System.out.println("--------- Teacher -------------");
        System.out.println("Id: " + id + " name:" + name);
        System.out.println("Courses: ");
        courses.forEach(c -> c.getName());
        System.out.println("-------------------------------");
    }
    
    

}