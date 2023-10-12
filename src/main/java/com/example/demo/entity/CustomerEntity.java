package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer age;
    private String address;

    public CustomerEntity() {
    }

    public CustomerEntity(Integer id, String name, Integer age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public CustomerEntity(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}

