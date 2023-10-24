package com.example.demo.dao;

import com.example.demo.entity.StudentEntity;

import java.util.List;

public interface StudentDAO extends RepositoryDAO<StudentEntity> {
    List<StudentEntity> searchByName(String name);
}
