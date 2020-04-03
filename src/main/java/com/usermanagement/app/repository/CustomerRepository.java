package com.usermanagement.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.usermanagement.app.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String>{
	
}
