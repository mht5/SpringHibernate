package com.test.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="t_student")
public class Student {

    @Id
    @GenericGenerator(name="myuuid", strategy="uuid")
    @GeneratedValue(generator="myuuid")
    private String id;

    @Length(min=1, max=255)
    private String name;

    @ManyToMany(targetEntity=Teacher.class)
    @JoinTable(name="t_student_teacher", joinColumns={@JoinColumn(name="student_id",referencedColumnName="id")}, inverseJoinColumns={@JoinColumn(name="teacher_id")})
    @Cascade(CascadeType.SAVE_UPDATE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Teacher> teachers = new HashSet<Teacher>();
    
    private transient List<String> teacherIdList = new ArrayList<>();

    public List<String> getTeacherIdList() {
		return teacherIdList;
	}
	public void setTeacherIdList(List<String> teacherIdList) {
		this.teacherIdList = teacherIdList;
	}
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
    public Set<Teacher> getTeachers() {
        return teachers;
    }
    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

}