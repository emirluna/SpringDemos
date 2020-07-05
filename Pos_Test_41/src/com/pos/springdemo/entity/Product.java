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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	
	@Column(name="name")
	private String Name;

	@Column(name="short_name")
	private String ShortName;

	@Column(name="measure")
	private int Measure;

	@Column(name="price")
	private float Price;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_category")
	private Category category;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="id_detail")
	private ProductDetail detail;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_enterprise")
	private Enterprise enterprise;
	
	@OneToMany(fetch= FetchType.EAGER,
			mappedBy="products",
			cascade= CascadeType.ALL)
	private List<Stock> stocks;
	
	public void add(Stock tempStock) {
		
		if(stocks == null) {
			stocks = new ArrayList<>();
		}		
		stocks.add(tempStock);	
		tempStock.setProducts(this);
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	/*
	@ManyToMany(fetch=FetchType.LAZY, 
			cascade= {CascadeType.PERSIST, CascadeType.DETACH,
					CascadeType.REFRESH, CascadeType.MERGE})	
	@JoinTable(
			name="BranchProduct",
			joinColumns=@JoinColumn(name="id_product"),
			inverseJoinColumns=@JoinColumn(name="id_stock"))
	private List<Stock> stock;
	
	
	public void add(Stock tempStock) {
		
		if(stock == null) {
			stock = new ArrayList<>();
		}
		
		stock.add(tempStock);
		
	}
	
	public List<Stock> getStock() {
		return stock;
	}


	public void setStock(List<Stock> stock) {
		this.stock = stock;
	}


	
	@ManyToMany(fetch=FetchType.LAZY, 
			cascade= {CascadeType.PERSIST, CascadeType.DETACH,
					CascadeType.REFRESH, CascadeType.MERGE})	
	@JoinTable(
			name="BranchProduct",
			joinColumns=@JoinColumn(name="id_product"),
			inverseJoinColumns=@JoinColumn(name="id_branch"))
	private List<Branch> branches;
	
	
	public void add(Branch tempBranch) {
		
		if(branches == null) {
			branches = new ArrayList<>();
		}
		
		branches.add(tempBranch);
		
	}
	
	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}
*/
	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public ProductDetail getDetail() {
		return detail;
	}

	public void setDetail(ProductDetail detail) {
		this.detail = detail;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	@Column(name="barcode")
	private String Barcode;

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

	public String getShortName() {
		return ShortName;
	}

	public void setShortName(String shortName) {
		ShortName = shortName;
	}

	public int getMeasure() {
		return Measure;
	}

	public void setMeasure(int measure) {
		Measure = measure;
	}

	public String getBarcode() {
		return Barcode;
	}

	public void setBarcode(String barcode) {
		Barcode = barcode;
	}

	public Product(String name, String shortName, int measure, float price, String barcode) {
		Name = name;
		ShortName = shortName;
		Measure = measure;
		Price = price;
		Barcode = barcode;
	}
	
	public Product(){
	}

	@Override
	public String toString() {
		return "Product [Id=" + Id + ", Name=" + Name + ", ShortName=" + ShortName + ", Measure=" + Measure
				+ ", Barcode=" + Barcode + "]";
	}
	
	
}
