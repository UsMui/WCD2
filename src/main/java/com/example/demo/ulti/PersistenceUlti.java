package com.example.demo.ulti;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUlti {
    private static EntityManagerFactory entityManagerFactory;
    public static synchronized EntityManagerFactory createEntityManagerFactory(){
        if(entityManagerFactory == null){
            entityManagerFactory = Persistence.createEntityManagerFactory("jpaDemo");
        }
        return entityManagerFactory;
    }
}
