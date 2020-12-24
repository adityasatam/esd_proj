package com.example.erp.bean;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer student_id;
    private String first_name;
    private String last_name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String roll_number;
    @Column(nullable = false)
    private Float cgpa;
    @Column(nullable = false)
    private Integer total_credits;
    private Integer graduation_year;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Student_Courses", joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private List<Courses> courses;

    public Students() {
        cgpa = 0.0f;
    }

    public Students(String first_name, String last_name, String email, String roll_number, Float cgpa, Integer total_credits, Integer graduation_year) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.graduation_year = graduation_year;
        this.roll_number = roll_number;
        this.cgpa = cgpa;
        this.total_credits = total_credits;
    }

    public String getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(String roll_number) {
        this.roll_number = roll_number;
    }

    public Float getCgpa() {
        return cgpa;
    }

    public void setCgpa(Float cgpa) {
        this.cgpa = cgpa;
    }

    public Integer getTotal_credits() {
        return total_credits;
    }

    public void setTotal_credits(Integer total_credits) {
        this.total_credits = total_credits;
    }

    public Integer getGraduation_year() {
        return graduation_year;
    }

    public void setGraduation_year(Integer graduation_year) {
        this.graduation_year = graduation_year;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }
}