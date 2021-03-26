package com.etech.poc_voitures.services.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etech.poc_voitures.data.entity.Voiture;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {

	Optional<Voiture> findById(Long id);
	Voiture findByModel(String model);
	
}
