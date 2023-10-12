package com.example.demo.dao.impl;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.entity.CustomerEntity;
import com.example.demo.ulti.PersistenceUlti;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOimpl implements CustomerDAO {

    EntityManager en;
    EntityTransaction tran;
    public CustomerDAOimpl(){
        en = PersistenceUlti.createEntityManagerFactory().createEntityManager();
        tran = en.getTransaction();
    }

    @Override
    public void createCustomer(CustomerEntity customer) {
        try{
            tran.begin();
            en.persist(customer);
            tran.commit();

        }catch (Exception ex){
            tran.rollback();
        }

    }

    @Override
    public List<CustomerEntity> getAllCustomer() {
        List<CustomerEntity> customers = new ArrayList<>();
        try{
            Query query = en.createQuery("select c from CustomerEntity c");
            return query.getResultList();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
