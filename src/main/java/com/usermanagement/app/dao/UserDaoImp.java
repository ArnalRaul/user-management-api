package com.usermanagement.app.dao;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.usermanagement.app.entity.ApplicationUser;
import com.usermanagement.app.repository.UserRepository;


public class UserDaoImp implements UserDao {
	
	@Autowired
	private UserRepository customerRepository;
	
	@Override
	public Optional<ApplicationUser> getCustomerById(String id) {
		return customerRepository.findById(id);
	
	}

	@Override
	public void updateUser(ApplicationUser customer) {
		

	}

	@Override
	public void deleteUser(String id) {
		customerRepository.deleteById(id);
	}

	@Override
	public void saveUser(ApplicationUser customer) {
		customerRepository.save(customer);

	}

	@Override
	public ApplicationUser getRegisteredUser(String id, String password) {
		
		return customerRepository.findUserAndPassWordCombination(id, password);
	}

}
