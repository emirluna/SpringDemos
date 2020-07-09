package com.pos.springdemo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Enterprise")
public class Enterprise {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	
	@Column(name="name")
	private String Name;

	@Column(name="area")
	private String Area;

	@OneToOne(fetch= FetchType.EAGER,
			cascade=CascadeType.ALL)
	@JoinColumn(name="id_address")
	private Address address;
	
	@OneToMany(fetch= FetchType.EAGER,
			mappedBy="enterprise",
			cascade= CascadeType.ALL)
	private List<Branch> branches;
	
	@OneToMany(fetch= FetchType.LAZY,
			mappedBy="enterprise",
			cascade= CascadeType.ALL)
	private List<Product> products;
	
	
	
public void add(Branch tempBranch) {
		
		if(branches == null) {
			branches = new ArrayList<>();
		}
		
		branches.add(tempBranch);
		
		tempBranch.setEnterprise(this);
	}
	
public void add(Product tempProduct) {
	
	if(products == null) {
		products = new ArrayList<>();
	}
	
	products.add(tempProduct);
	
	tempProduct.setEnterprise(this);
}
	
	public List<Product> getProducts() {
	return products;
}

public void setProducts(List<Product> products) {
	this.products = products;
}

	public Address getAddress() {
	return address;
}



public void setAddress(Address address) {
	this.address = address;
}



public List<Branch> getBranches() {
	return branches;
}



public void setBranches(List<Branch> branches) {
	this.branches = branches;
}



	public Enterprise(String name, String area) {
		Name = name;
		Area = area;
	}

	public Enterprise() {
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

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	@Override
	public String toString() {
		return "Enterprise [Id=" + Id + ", Name=" + Name + ", Area=" + Area + "]";
	}
	
	
	
	
}
