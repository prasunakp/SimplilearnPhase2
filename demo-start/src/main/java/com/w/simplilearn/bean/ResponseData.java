package com.w.simplilearn.bean;

import java.util.List;

public class ResponseData {
	
	private List<UserData> users;
	
	private List<ProductData> products;

	
	public List<UserData> getUsers() {
		return users;
	}

	public void setUsers(List<UserData> users) {
		this.users = users;
	}

	public List<ProductData> getProducts() {
		return products;
	}

	public void setProducts(List<ProductData> products) {
		this.products = products;
	}


}
