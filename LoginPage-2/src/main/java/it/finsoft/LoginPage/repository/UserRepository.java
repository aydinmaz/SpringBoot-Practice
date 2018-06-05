package it.finsoft.LoginPage.repository;

import org.springframework.data.repository.CrudRepository;

import it.finsoft.LoginPage.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
}
