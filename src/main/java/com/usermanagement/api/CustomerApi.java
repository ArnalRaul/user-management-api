package com.usermanagement.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.service.SecurityService;

@RestController
public class CustomerApi {

	@Autowired
	SecurityService securityService;
	
	@RequestMapping(value="/customer" , method=RequestMethod.POST)
	public String getCustomerPassWord(@RequestParam("pass") String password) {
		
		return securityService.encodePassword(password);
		
	}
	
	
}
