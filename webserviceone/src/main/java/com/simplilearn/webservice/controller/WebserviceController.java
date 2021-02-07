package com.simplilearn.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.webservice.entity.ProductEntity;
import com.simplilearn.webservice.response.ProductResponse;
import com.simplilearn.webservice.service.ProductService;

@RestController
@RequestMapping(path = "/web")
public class WebserviceController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/product/{Id}")
	public ProductResponse getProduct(@PathVariable int id)
	{
		ProductEntity productEntity =  productService.getProductById(id).get();
		
		ProductResponse response = new ProductResponse();
		response.setId(productEntity.getProductCode());
		response.setName(productEntity.getName());
		response.setPrice(productEntity.getPrice());
		 
		return response;
	}
	
	@PostMapping("/product")
	public void addProduct(@RequestBody ProductEntity product)
	{
		productService.addProduct(product);
	}
	
	@GetMapping("/products")
	public List<ProductEntity> getAllProducts()
	{
		return productService.getAllProducts();
	}
	
	

}
