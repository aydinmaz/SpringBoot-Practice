package it.finsoft.LoginPage.model;
import javax.persistence.*;

import java.util.List;


@Entity 
@Table(name="user")
public class User 
{
	private long id;
	private String username;
	private String name;
	private String email;
	private String password;
	private String passwordConfirm;
	private List<Role>roles;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Transient//password confirm doesn't get saved in MYSQL
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	@ManyToMany
	@JoinTable(name = "user_role",joinColumns = @JoinColumn(name= "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	

}
