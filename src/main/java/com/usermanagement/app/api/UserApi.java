package com.usermanagement.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.app.entity.ApplicationUser;
import com.usermanagement.app.service.UserService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserApi {

	@Autowired
	UserService userService;
	@Autowired
	UserDetailsService userDetailService;
	
	@PostMapping(value = "/save")
	public ResponseEntity<Boolean> saveUser(@RequestBody ApplicationUser customerRequest) {
		try {
		return new ResponseEntity<Boolean>(userService.saveUser(customerRequest),HttpStatus.OK);
		}catch(Exception e) {
			System.out.print(e);
			return new ResponseEntity<Boolean>(Boolean.FALSE, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/findUser")
	public ResponseEntity<ApplicationUser> getUserRegistered(@RequestParam String id, @RequestParam String password) {
		ApplicationUser customer = null;
		try {
			customer = userService.findUserPasswordCombination(id, password);
		 
			return new ResponseEntity<ApplicationUser>(customer, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ApplicationUser>(customer, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
