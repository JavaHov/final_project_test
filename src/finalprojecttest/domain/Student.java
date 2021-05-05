package finalprojecttest.domain;

import javax.persistence.Basic;
import javax.persistence.Cacheable;
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
@Cacheable(false)
public class Student {

    @Id
    @GeneratedValue
    private int id;
    @Basic
    private String name;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Education education;
    private int age;

    public Student() {
        
    }
    
    public Student(String name, int age) {
        
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
    
    public void removeEducation(Education education) {
        
        this.education = null; // Vet inte om det här fungerar...mot databasen.
    }

    public void print() {
        
        System.out.println("-------------------- Student -----------------------");
        System.out.print("Id: " + id + " name: " + name + " age: " + age + " education ");
        if(education == null)
            System.out.println("(no education chosen)");
        else
            System.out.println(education.getName());
        System.out.println("----------------------------------------------------");
    }
    
}