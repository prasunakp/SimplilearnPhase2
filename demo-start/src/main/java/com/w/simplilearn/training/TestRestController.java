package com.w.simplilearn.training;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.w.simplilearn.bean.ProductData;
import com.w.simplilearn.bean.ResponseData;
import com.w.simplilearn.bean.UserData;
import com.w.simplilearn.repository.ProductTransactionRepository;
import com.w.simplilearn.repository.UserTransactionRepository;
import com.w.simplilearn.service.UserService;
import com.w.training.entity.ProductDetails;
import com.w.training.entity.UserDetails;

/**
 * @author PRASSU
 *
 */
@RestController
@RequestMapping(value = "/class")
public class TestRestController {
	
	@Autowired(required = true)
	UserTransactionRepository userTransactionRepository;
	
	@Autowired(required = true)
	ProductTransactionRepository productTransactionRepository;
	
	@RequestMapping(value = "/testMessage")
	void getMessage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
	List<ProductDetails> products =	productTransactionRepository.findAll();
	
	List<UserDetails> users = userTransactionRepository.findAll();
	
	List<ProductData> listOfProducts = convertProductData(products);
	
	List<UserData> listOfUsers = convertUserData(users);
	ResponseData responseData = new ResponseData();
	responseData.setProducts(listOfProducts);
	responseData.setUsers(listOfUsers);
	
	request.getSession().setAttribute("attribute", responseData);
	
	request.getServletContext().getRequestDispatcher("/success.html").forward(request, response);
		
		
	}
	
	@PostMapping(value = "/addUser")
	String addUser(@RequestBody UserDetails user)
	{
		userTransactionRepository.save(user);
		
		return "Success";
		
	}
	
	@RequestMapping(value = "/getProducts")
	@ResponseBody
	List<ProductDetails> getProducts()
	{
		return productTransactionRepository.findAll();
	}
	
	@PostMapping(value = "/addProducts")
	String addProducts(@RequestBody ProductDetails product)
	{
		productTransactionRepository.save(product);
		return "Success";
		
	}
	
	public List<ProductData> convertProductData(List<ProductDetails> products)
	{
		List<ProductData> listOfProducts = new ArrayList<>();
		
		for(ProductDetails productDetail : products)
		{
			ProductData product = new ProductData();
			product.setCategoryCode(productDetail.getCategory());
			product.setProductCode(productDetail.getProductcode());
			product.setPurchasedDate(productDetail.getPurchaseddate());
			listOfProducts.add(product);
		}
		
		return listOfProducts;
	}
	
	public List<UserData> convertUserData(List<UserDetails> users)
	{
		List<UserData> listOfUsers = new ArrayList<>();
		
		for(UserDetails user : users)
		{
			UserData userData = new UserData();
			userData.setEmail(user.getEmailid());
			userData.setName(user.getName());
			userData.setPhonenumber(user.getPhonenumber());
			listOfUsers.add(userData);
		}
		return listOfUsers;
		
	}
	
}
