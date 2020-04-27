package com.usermanagement.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.usermanagement.app.dao.UserDao;
import com.usermanagement.app.entity.ApplicationUser;



@Service
class UserServiceImp implements UserService {
	@Autowired
    private  BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserDao customerDao;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	public ApplicationUser findUserPasswordCombination(String id, String password) {
		if(!StringUtils.isEmpty(id)&&!StringUtils.isEmpty(password)) {
		return customerDao.getRegisteredUser(id,bCryptPasswordEncoder.encode(password));
		}else {
			return null;
		}
	}

	@Override
	public boolean saveUser(ApplicationUser customer) {
		if(customer!=null&&customer.getPassword()!=null&&!customerDao.getCustomerById(customer.getId()).isPresent()) {
			customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
			customerDao.saveUser(customer);
			return true;
		}
		return false;
	}

	@Override
	public ApplicationUser findUserById(String id) {
		ApplicationUser user =null;
		Optional<ApplicationUser> appUserOptional =  customerDao.getCustomerById(id);
		if(appUserOptional.isPresent()) {
			user = appUserOptional.get();
		}
		return user;
	}
	
	public void autologin(String username, String password) {
	    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
	    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken 
	    = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

	    authenticationManager.authenticate(usernamePasswordAuthenticationToken);

	    if (usernamePasswordAuthenticationToken.isAuthenticated()) {
	        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
	    }
	}
}
