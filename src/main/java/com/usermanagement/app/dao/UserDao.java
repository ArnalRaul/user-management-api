package com.usermanagement.app.dao;

import java.util.Optional;

import com.usermanagement.app.entity.ApplicationUser;

public interface UserDao {
	Optional<ApplicationUser> getCustomerById(String id);
	void updateUser(ApplicationUser applicationUser);
	void deleteUser(String id);
	void saveUser(ApplicationUser applicationUser);
	ApplicationUser getRegisteredUser(String id, String password);
	
}
