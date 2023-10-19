package com.example.demo.dao.impl;

import com.example.demo.dao.StudentDAO;
import com.example.demo.entity.StudentEntity;
import com.example.demo.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoimpl implements StudentDAO {



    EntityManager en;
    EntityTransaction tran;

    public StudentDaoimpl() {
        en = PersistenceUtil.createEntityManagerFactory().createEntityManager();
        tran = en.getTransaction();
    }
    @Override
    public List<StudentEntity> all() {
        List<StudentEntity> students = new ArrayList<>();
        try {
            Query query = en.createQuery("select c from StudentEntity c");
            return query.getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return students;
    }


    @Override
    public void create(StudentEntity studentEntity) {
        try {
            tran.begin();
            en.persist(studentEntity);
            tran.commit();
        } catch (Exception ex) {
            System.out.printf(ex.getMessage());
            tran.rollback();
        }

    }

    @Override
    public void update(StudentEntity studentEntity) {
        try {
            tran.begin();
            en.merge(studentEntity);
            tran.commit();
        } catch (Exception ex) {
            System.out.printf(ex.getMessage());
            tran.rollback();
        }

    }

    @Override
    public void delete(StudentEntity studentEntity) {
        StudentEntity student = en.find(StudentEntity.class, studentEntity.getId());
        if (student != null) {
            try {
                tran.begin();
                en.remove(student);
                tran.commit();
            } catch (Exception ex) {
                System.out.printf(ex.getMessage());
                tran.rollback();
            }
        }

    }

    @Override
    public StudentEntity findOne(Integer id) {
        return en.find(StudentEntity.class, id);
    }
}
