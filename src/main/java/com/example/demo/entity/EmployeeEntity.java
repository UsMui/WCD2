package com.example.demo.entity;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullname;
    private Date birthday;
    private String address;
    private String position;
    private String department;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public EmployeeEntity() {
    }

    public EmployeeEntity(Integer id, String fullname, Date birthday, String address, String position, String department) {
        this.id = id;
        this.fullname = fullname;
        this.birthday = birthday;
        this.address = address;
        this.position = position;
        this.department = department;
    }

    public EmployeeEntity(String fullname, Date birthday, String address, String position, String department) {
        this.fullname = fullname;
        this.birthday = birthday;
        this.address = address;
        this.position = position;
        this.department = department;
    }
}
