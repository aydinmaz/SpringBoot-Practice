package it.finsoft.LoginPage.repository;


import it.finsoft.LoginPage.model.Role;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
	
   public List<Role> findAll();
}
