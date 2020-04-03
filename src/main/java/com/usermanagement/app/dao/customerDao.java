package com.usermanagement.app.dao;

import com.usermanagement.app.entity.Customer;

public interface customerDao {
	Customer getCustomerById(String id);
	void updateCustomer(Customer customer);
	boolean deleteCustomer(String id);
	void saveCustomer(Customer customer);
}
