package com.xoriant.bank.authenticationservice.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;





enum Role {

	MANAGER, CUSTOMER
}

@Entity
public class User {

	@Id
	@GeneratedValue
	private int userId;
	private String userName;
	private String password;
	@Column(columnDefinition = "ENUM('MANAGER', 'CUSTOMER')")
	@Enumerated(EnumType.STRING)
	private Role role;

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id")
	private PersonInfo person;	
	
	



	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
	}

	public PersonInfo getPerson() {
		return person;
	}

	public void setPerson(PersonInfo person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", role=" + role
				+ ", person=" + person + "]";
	}

	

	
}
