package com.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
class SecurityServiceImp implements SecurityService {
	
	@Autowired
    private  BCryptPasswordEncoder bCryptPasswordEncoder;

	
	@Override
	public String encodePassword(String password) {
		return bCryptPasswordEncoder.encode(password);
	}

}
