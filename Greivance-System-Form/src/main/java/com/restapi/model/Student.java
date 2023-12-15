package com.restapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "regd_num")
    private String regdNum;

    @Column(name = "dob")
    private String dob;

    @Column(name = "year")
    private int year;

    @Column(name = "department")
    private String department;

    public Student() {
    }

    public Student(long id, String name, String regdNum, String dob, int year, String department) {
        this.id = id;
        this.name = name;
        this.regdNum = regdNum;
        this.dob = dob;
        this.year = year;
        this.department = department;
    }

    // Getters and setters

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRegdNum() {
        return regdNum;
    }

    public String getDob() {
        return dob;
    }

    public int getYear() {
        return year;
    }

    public String getDepartment() {
        return department;
    }
    
     public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegdNum(String regdNum) {
        this.regdNum = regdNum;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", regdNum=" + regdNum + ", dob=" + dob + ", year=" + year
                + ", department=" + department + "]";
    }
    
}
