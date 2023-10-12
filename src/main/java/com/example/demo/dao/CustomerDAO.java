package com.example.demo.dao;

import com.example.demo.entity.CustomerEntity;

import java.util.List;

public interface CustomerDAO {
    void createCustomer(CustomerEntity customer);
    List<CustomerEntity> getAllCustomer();
}
