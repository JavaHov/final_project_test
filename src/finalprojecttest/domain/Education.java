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
    @OneToMany(mappedBy = "education", fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.PERSIST})
    private List<Student> students = new ArrayList<Student>();
    @OneToMany(mappedBy = "education", fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.PERSIST})
    private List<Course> courses = new ArrayList<>();
    
    
    
    private int points;
    
    public Education() {
        
    }
    
    public Education(String name) {
        
        this.name = name;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void removeStudents() {
        
            for (Student student : students) {
            
            student.setEducation(null);
            
        }
    }

    public List<Course> getCourses() {
    
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
        course.setEducation(this);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
        course.setEducation(null);
    }
    
    public void removeCourses() {
       //courses.clear();
        for (Course course : courses) {
            
            course.setEducation(null);
            
        }
    }

    public void print() {
        
        System.out.println("---------- Education --------------");
        System.out.println("Id: " + id + ", name: " + name + ", points: " + points);
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