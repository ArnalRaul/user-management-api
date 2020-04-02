package com.usermanagement.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.app.service.SecurityService;

@RestController
@RequestMapping(value="/password" )
public class PasswordApi {

	@Autowired
	SecurityService securityService;
	
	@RequestMapping(value="/encode" , method=RequestMethod.GET)
	public String getCustomerPassWord(@RequestParam("pass") String password) {
		
		return securityService.encodePassword(password);
		
	}
	
	
}
