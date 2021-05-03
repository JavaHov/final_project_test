package finalprojecttest.domain;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author Me
 */
@Entity
public class Student {

    @Id
    @GeneratedValue
    private int id;
    @Basic
    private String name;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Education education;

    public Student() {
        
    }
    
    public Student(String name) {
        
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

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", education=" + education + '}';
    }
    
    

}