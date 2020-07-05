package com.pos.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Address")
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	
	@Column(name="country")
	private String Country;
	
	@Column(name="state")
	private String State;
	
	@Column(name="city")
	private String City;
	
	@Column(name="street")
	private String Street;
	
	@Column(name="number")
	private String Number;
	
	
	public Address() {}


	public Address(String country, String state, String city, String street, String number) {
		Country = country;
		State = state;
		City = city;
		Street = street;
		Number = number;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getCountry() {
		return Country;
	}


	public void setCountry(String country) {
		Country = country;
	}


	public String getState() {
		return State;
	}


	public void setState(String state) {
		State = state;
	}


	public String getCity() {
		return City;
	}


	public void setCity(String city) {
		City = city;
	}


	public String getStreet() {
		return Street;
	}


	public void setStreet(String street) {
		Street = street;
	}


	public String getNumber() {
		return Number;
	}


	public void setNumber(String number) {
		Number = number;
	}


	@Override
	public String toString() {
		return "Address [Id=" + Id + ", Country=" + Country + ", State=" + State + ", City=" + City + ", Street="
				+ Street + ", Number=" + Number + "]";
	}

	
	
}
