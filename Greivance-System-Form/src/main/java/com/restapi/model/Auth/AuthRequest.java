package com.restapi.model.Auth;

public class AuthRequest {
    private String name; 
    private String password;
    private String department;
    private String position;
    private String regdNum;
    private String dob;
    public AuthRequest() {
    }
    
    public AuthRequest(String name, String password, String department, String position) {
        this.name = name;
        this.password = password;
        this.department = department;
        this.position = position;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public String getDepartment() {
        return department;
    }
    public String getPosition() {
        return position;
    }
    
    public String getRegdNum() {
        return regdNum;
    }
    public String getDob() {
        return dob;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    
    public void setRegdNum(String regdNum) {
        this.regdNum = regdNum;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    @Override
    public String toString() {
        return "AuthRequest [name=" + name + ", password=" + password + ", department=" + department + ", position="
                + position + "]";
    }

    // Constructors, getters, setters, and toString method
    
}
