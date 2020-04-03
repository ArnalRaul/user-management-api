package com.usermanagement.app.dao;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.usermanagement.app.entity.Customer;
import com.usermanagement.app.repository.CustomerRepository;

public class CustomerDaoImp implements customerDao {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer getCustomerById(String id) {
		Optional<Customer> customerOptional = customerRepository.findById(id);
		if(customerOptional.isPresent()) {
			return customerOptional.get();
		}else {
			return null;
		}
	
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean deleteCustomer(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

}
