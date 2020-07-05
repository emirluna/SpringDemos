package com.pos.springdemo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	
	@Column(name="name")
	private String Name;
	
	@Column(name="last_name")
	private String LastName;
	
	@Column(name="username")
	private String UserName;
	
	@Column(name="password")
	private String Password;
	
	@Column(name="email")
	private String Email;
	
	@Column(name="phone")
	private String Phone;

	/*@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_enterprise")
	private Enterprise enterprise;
	*/
	
	public Users() {}
	
	
	public Users(String name, String lastName, String userName, String password, String email, String phone) {
		Name = name;
		LastName = lastName;
		UserName = userName;
		Password = password;
		Email = email;
		Phone = phone;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public String getUserName() {
		return UserName;
	}


	public void setUserName(String userName) {
		UserName = userName;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getPhone() {
		return Phone;
	}


	public void setPhone(String phone) {
		Phone = phone;
	}


	@Override
	public String toString() {
		return "Users [Id=" + Id + ", Name=" + Name + ", LastName=" + LastName + ", UserName=" + UserName
				+ ", Password=" + Password + ", Email=" + Email + ", Phone=" + Phone + "]";
	}
	
	
	
	
}
