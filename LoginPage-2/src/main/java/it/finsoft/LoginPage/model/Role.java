package it.finsoft.LoginPage.model;

import java.util.List;

import javax.persistence.*;

@Entity 
public class Role {
	private int id;
	private String name;
	private List<User>users;
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ManyToMany
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	

}
