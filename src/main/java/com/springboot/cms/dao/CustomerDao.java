package com.springboot.cms.dao;

import com.springboot.cms.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao extends CrudRepository <Customer, Integer>{

    @Override
    public List<Customer> findAll();
}
