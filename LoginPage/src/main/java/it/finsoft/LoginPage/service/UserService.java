package it.finsoft.LoginPage.service;

import it.finsoft.LoginPage.model.User;

public interface UserService 
{
	 public void save(User user);
	 public User findByUsername(String username);
	 public User findByEmail(String email);

}
