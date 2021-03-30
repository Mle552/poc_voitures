package com.etech.poc_voitures.services.applicatif.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


import com.etech.poc_voitures.data.dto.comment.CommentDTO;
import com.etech.poc_voitures.data.dto.comment.VoitureCommentDTO;
import com.etech.poc_voitures.data.entity.Comment;
import com.etech.poc_voitures.mapper.CommentMapper;
import com.etech.poc_voitures.mapper.VoitureMapper;
import com.etech.poc_voitures.services.repository.CommentRepository;
import com.etech.poc_voitures.services.repository.VoitureRepository;

import com.etech.poc_voitures.data.entity.Voiture;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

public class CommentSAImpl implements CommentSA{
	@Autowired
	CommentMapper commentMapper;

	@Autowired
	VoitureMapper voitureMapper;

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	VoitureRepository voitureRepository;
	
	@Override
	public CommentDTO saveComment(CommentDTO dto) {
		Comment comment = commentRepository.save(commentMapper.dtoToComment(dto));
		dto.setId(comment.getId());
		return dto;
	}
	
	@Override
	public VoitureCommentDTO getVoitureComment(Long voitureID, Integer pageNo, Integer pageSize, String sortBy) {
		//paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
		Optional<Voiture> voiture = voitureRepository.findById(voitureID);
		Pageable paging;
		if(StringUtils.isEmpty(sortBy)) {
			sortBy = "id";
		}
		paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
		Page<Comment> commentsPaged = commentRepository.findCommentByVoiture(voiture.get(), paging);
		if (commentsPaged.hasContent()) {
			return new VoitureCommentDTO(voitureMapper.voitureToDto(voiture.get()), commentMapper.commentsToDtos(commentsPaged.getContent()));
		} else {
			return new VoitureCommentDTO();
		}
	}
	
}
