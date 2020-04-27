package com.usermanagement.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.usermanagement.app.entity.ApplicationUser;

public interface UserRepository extends CrudRepository<ApplicationUser, String>{
	@Query("Select cu from ApplicationUser cu where cu.id = :id" )
	public ApplicationUser findCustomerById(String id);
	
	@Query("Select cu from ApplicationUser cu where cu.id = :id and cu.password = :password")
    public ApplicationUser findUserAndPassWordCombination(String id , String password);
}
