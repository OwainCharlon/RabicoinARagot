package ynov.owain.RAR.dao.model;

public class User {
	
	private Integer userID;
	private String firstname;
	private String lastname;
	private String login;
	private String password;
	
	public Integer getUserID() {
		return userID;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public String getLogin() {
		return login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
