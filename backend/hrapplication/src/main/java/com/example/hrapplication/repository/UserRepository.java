package com.example.hrapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hrapplication.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
