package com.etech.poc_voitures.mapper;

import com.etech.poc_voitures.data.dto.user.UserDTO;
import com.etech.poc_voitures.data.entity.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {

	UserDTO userToDto(User user);
}
