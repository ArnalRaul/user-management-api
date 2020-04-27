package com.usermanagement.app.service;

import com.usermanagement.app.entity.ApplicationUser;

public interface UserService {
	ApplicationUser findUserPasswordCombination(String id, String password);
	
	boolean saveUser(ApplicationUser customer);
	
	ApplicationUser findUserById(String id);
}
