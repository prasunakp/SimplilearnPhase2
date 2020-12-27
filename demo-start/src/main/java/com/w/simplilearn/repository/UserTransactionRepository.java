package com.w.simplilearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.w.training.entity.UserDetails;

@Repository
public interface UserTransactionRepository extends JpaRepository<UserDetails, Integer> {

}
