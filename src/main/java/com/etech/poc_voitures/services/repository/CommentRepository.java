package com.etech.poc_voitures.services.repository;

import com.etech.poc_voitures.data.entity.Comment;
import com.etech.poc_voitures.data.entity.Voiture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CommentRepository extends JpaRepository<Comment, Long> {

	@Query("select c from Comment c WHERE c.voiture = :voiture")
	Page<Comment> findCommentByVoiture(Voiture voiture, Pageable pageable);
}
