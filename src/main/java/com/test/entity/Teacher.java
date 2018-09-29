package com.test.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="t_teacher")
public class Teacher {

    @Id
    @GenericGenerator(name="myuuid", strategy="uuid")
    @GeneratedValue(generator="myuuid")
    private String id;

    @Length(min=1, max=255)
    private String name;

    @ManyToMany(targetEntity=Student.class, mappedBy="teachers")
    private Set<Student> students = new HashSet<Student>();

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Set<Student> getStudents() {
        return students;
    }
    public void setStudents(Set<Student> students) {
        this.students = students;
    }

}