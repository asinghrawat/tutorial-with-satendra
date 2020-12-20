package com.anilsatendra.mvctutorial.tutorialspringmvc.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<Login, Long> {
	public Login findByPassword(String password);
	
	public Login findByUsernameAndPassword(String username, String Password);
}
