package com.etech.poc_voitures.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etech.poc_voitures.data.DAOUser;
import com.etech.poc_voitures.data.dto.user.UserDTO;
import com.etech.poc_voitures.data.entity.User;


public interface UserRepository extends JpaRepository<DAOUser, Long>{
	DAOUser findByUsername(String username);
}
