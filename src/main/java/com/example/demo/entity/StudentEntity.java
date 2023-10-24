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
    private String tel;
    private String thumbnail;
    private Date birthday;

    public StudentEntity() {
    }

    public StudentEntity(Integer id, String name, Date birthday, String tel) {
        this.id = id;
        this.name = name;
        this.tel = tel;
    }



    public StudentEntity(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    public StudentEntity(String name) {
        this.name = name;
    }

    public StudentEntity(Integer id, String name, String tel) {
    }

    public StudentEntity(String name, String tel, String thumbnail, Date birthday) {
        this.name = name;
        this.tel = tel;
        this.thumbnail = thumbnail;
        this.birthday = birthday;
    }

    public StudentEntity(Integer id, String name, String tel, String thumbnail, Date birthday) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.thumbnail = thumbnail;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getTel() {
        return tel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


}
