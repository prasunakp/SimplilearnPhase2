package com.w.training.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Tells Hibernate this is our Entity class
@Table(name = "productdetails")
public class ProductDetails {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name = "productcode")
	String productcode;
	
	@Column(name = "category")
	String category;
	
	@Column(name = "purchaseddate")
	String purchaseddate;
	
	
	public String getProductcode() {
		return productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPurchaseddate() {
		return purchaseddate;
	}

	public void setPurchaseddate(String purchaseddate) {
		this.purchaseddate = purchaseddate;
	}

}
