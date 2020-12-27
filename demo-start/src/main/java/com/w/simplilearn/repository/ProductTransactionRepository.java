package com.w.simplilearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.w.training.entity.ProductDetails;

@Repository
public interface ProductTransactionRepository extends JpaRepository<ProductDetails, Integer>{

}
