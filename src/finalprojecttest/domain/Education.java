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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author Me
 */
@Entity
@Cacheable(false)
public class Education {

    @Id
    @GeneratedValue
    private int id;
    @Basic
    private String name;
    @OneToMany(mappedBy = "education", fetch = FetchType.EAGER)
    private List<Student> students;
    @OneToMany(mappedBy = "education", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Course> courses;
    
    public Education() {
        
    }
    
    public Education(String name) {
        
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void removeStudents() {
        students.clear();
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
        course.setEducation(this);
    }

    public void removeCourse(Course course) {
        getCourses().remove(course);
        course.setEducation(null);
    }
    
    public void removeCourses() {
        courses.clear();
    }

    public void print() {
        
        System.out.println("---------- Education --------------");
        System.out.println("Id: " + id + " name: " + name);
        System.out.println("Courses: ");
        if(courses == null)
            System.out.println("(no registered courses)");
        else
        courses.forEach(c -> System.out.println(c.getName()));
        
        System.out.println("Students: ");
        if(students == null)
            System.out.println("(no registered students)");
        else
            students.forEach(s -> System.out.println(s.getName()));
        System.out.println("-----------------------------------");
    }
    
    

}