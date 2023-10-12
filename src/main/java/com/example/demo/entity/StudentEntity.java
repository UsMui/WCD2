package com.example.demo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="students")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Date birthday;
    private String tel;

    public StudentEntity() {
    }

    public StudentEntity(Integer id, String name, Date birthday, String tel) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.tel = tel;
    }

    public StudentEntity(String name, Date birthday, String tel) {
        this.name = name;
        this.birthday = birthday;
        this.tel = tel;
    }

    public StudentEntity(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getTel() {
        return tel;
    }
}