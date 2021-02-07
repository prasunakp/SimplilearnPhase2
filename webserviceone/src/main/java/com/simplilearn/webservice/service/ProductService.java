package com.simplilearn.webservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.webservice.entity.ProductEntity;
import com.simplilearn.webservice.repository.ProductRepository;
import com.simplilearn.webservice.response.ProductResponse;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;
	
	public Optional<ProductEntity> getProductById(int id)
	{
	    return productRepo.findById(id);
	}
	
	public void addProduct(ProductEntity product)
	{
		productRepo.save(product);
	}
	
	public  List<ProductEntity> getAllProducts()
	{
		return productRepo.findAll();
	}
}
