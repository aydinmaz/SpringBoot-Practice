package it.finsoft.LoginPage.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.finsoft.LoginPage.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	public List<Role> findAll();

}
