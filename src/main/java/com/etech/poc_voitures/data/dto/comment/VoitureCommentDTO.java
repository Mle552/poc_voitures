package com.etech.poc_voitures.data.dto.comment;

import com.etech.poc_voitures.data.dto.common.GenericDTO;
import com.etech.poc_voitures.data.dto.voiture.VoitureDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class VoitureCommentDTO extends GenericDTO {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	VoitureDTO voiture;
	List<CommentDTO> comments;

	public VoitureCommentDTO() {
	}

	public VoitureCommentDTO(VoitureDTO voiture, List<CommentDTO> comments) {
		this.voiture = voiture;
		this.comments = comments;
	}

	public VoitureDTO getVoiture() {
		return voiture;
	}

	public void setVoiture(VoitureDTO voiture) {
		this.voiture = voiture;
	}

	public List<CommentDTO> getComments() {
		return comments;
	}

	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}

}
