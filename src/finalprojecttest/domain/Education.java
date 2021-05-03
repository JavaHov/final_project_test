package finalprojecttest.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
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
public class Education {

    @Id
    @GeneratedValue
    private int id;
    @Basic
    private String name;
    @OneToOne(mappedBy = "education")
    private Student student;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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

    @Override
    public String toString() {
        return "Education{" + "id=" + id + ", name=" + name + ", student=" + student.getName() + '}';
    }
    
    

}