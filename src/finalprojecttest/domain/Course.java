package finalprojecttest.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
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

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", name=" + name + ", education=" + education + ", teachers=" + teachers + '}';
    }
    
    

}