package com.pos.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product_Detail")
public class ProductDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	
	@Column(name="brand")
	private String Brand;
	
	@Column(name="description")
	private String Description;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@Override
	public String toString() {
		return "ProductDetail [Id=" + Id + ", Brand=" + Brand + ", Description=" + Description + "]";
	}

	public ProductDetail(String brand, String description) {
		Brand = brand;
		Description = description;
	}
	
	public ProductDetail() {}
	
	
}
