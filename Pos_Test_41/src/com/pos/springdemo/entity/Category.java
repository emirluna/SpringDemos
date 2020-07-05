package com.pos.springdemo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	
	@Column(name="name")
	private String Name;

	@OneToMany(mappedBy="category",
			cascade= CascadeType.ALL)
	private List<Product> products;

	
	public void add(Product tempProduct) {
		
		if(products == null) {
			products = new ArrayList<>();
		}
		
		products.add(tempProduct);
		
		tempProduct.setCategory(this);
	}
	
	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public Category() {}
	
	
	public Category(String name) {
		Name = name;
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


	@Override
	public String toString() {
		return "Category [Id=" + Id + ", Name=" + Name + "]";
	}
	
	
	
}
