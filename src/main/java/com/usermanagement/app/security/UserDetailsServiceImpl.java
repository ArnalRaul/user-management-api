package com.usermanagement.app.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usermanagement.app.entity.ApplicationUser;
import com.usermanagement.app.service.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserService userService;
	
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ApplicationUser user = userService.findUserById(username);
		
		Set grantedAuthorities = new HashSet();
		if(user==null) {
			throw new UsernameNotFoundException("Id not found");
		}
		return new User(user.getName(), user.getPassword(),grantedAuthorities);
	
	}

}
