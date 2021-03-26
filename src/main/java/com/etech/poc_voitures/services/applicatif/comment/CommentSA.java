package com.etech.poc_voitures.services.applicatif.comment;

import com.etech.poc_voitures.data.dto.comment.CommentDTO;
import com.etech.poc_voitures.data.dto.comment.VoitureCommentDTO;


public interface CommentSA {
	public CommentDTO saveComment(CommentDTO dto);
	public VoitureCommentDTO getVoitureComment(Long voitureID, Integer pageNo, Integer pageSize, String sortBy);
}
