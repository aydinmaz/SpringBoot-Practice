package it.finsoft.LoginPage.service;

public interface SecurityService {
	public void autologin(String username, String password);
	 public String findLoggedInUsername();

}
