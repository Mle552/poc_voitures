package com.etech.poc_voitures.mapper;

import com.etech.poc_voitures.data.dto.comment.CommentDTO;
import com.etech.poc_voitures.data.entity.Comment;
import java.util.List;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {UserMapper.class, VoitureMapper.class})
public interface CommentMapper {

	CommentDTO commentToDto(Comment comment);

	Comment dtoToComment(CommentDTO comment);

	List<CommentDTO> commentsToDtos(List<Comment> comments);
	
}
