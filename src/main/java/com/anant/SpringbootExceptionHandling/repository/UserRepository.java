package com.anant.SpringbootExceptionHandling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anant.SpringbootExceptionHandling.entity.User;

public interface UserRepository  extends JpaRepository<User,Integer> {
    User findByUserId(int id);

	
}