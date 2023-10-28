package com.example.demo.dao.impl;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.entity.StudentEntity;
import com.example.demo.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOimpl implements EmployeeDAO {
    EntityManager en;
    EntityTransaction tran;

    public EmployeeDAOimpl() {
        en = PersistenceUtil.createEntityManagerFactory().createEntityManager();
        tran = en.getTransaction();
    }
    @Override
    public List<EmployeeEntity> all() {
        List<EmployeeEntity> employeeEntities = new ArrayList<>();
        try {
            Query query = en.createQuery("select c from EmployeeEntity c");
            return query.getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return employeeEntities;
    }

    @Override
    public List<EmployeeEntity> all(int pageNumber, int pageSize) {
        List<EmployeeEntity> employeeEntities = new ArrayList<>();
        try {
            Query query = en.createQuery("SELECT c FROM EmployeeEntity c");
            query.setFirstResult((pageNumber - 1) * pageSize);
            query.setMaxResults(pageSize);
            return query.getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return employeeEntities;
    }

    @Override
    public void create(EmployeeEntity employeeEntity) {
        try {
            tran.begin();
            en.persist(employeeEntity);
            tran.commit();
        } catch (Exception ex) {
            System.out.printf(ex.getMessage());
            tran.rollback();
        }

    }

    @Override
    public void update(EmployeeEntity employeeEntity) {
        try {
            tran.begin();
            en.merge(employeeEntity);
            tran.commit();
        } catch (Exception ex) {
            System.out.printf(ex.getMessage());
            tran.rollback();
        }
    }
    @Override
    public void delete(EmployeeEntity employeeEntity) {
        EmployeeEntity employee = en.find(EmployeeEntity.class, employeeEntity.getId());
        if (employee!= null) {
            try {
                tran.begin();
                en.remove(employee);
                tran.commit();
            } catch (Exception ex) {
                System.out.printf(ex.getMessage());
                tran.rollback();
            }
        }

    }

    @Override
    public EmployeeEntity findOne(Integer id) {
        return en.find(EmployeeEntity.class,id);
    }
}
