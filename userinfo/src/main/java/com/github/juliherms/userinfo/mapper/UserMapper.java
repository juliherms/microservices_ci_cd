package com.github.juliherms.userinfo.mapper;


import com.github.juliherms.userinfo.dto.UserDTO;
import com.github.juliherms.userinfo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapUserDTOToUser(UserDTO userDTO);

    UserDTO mapUserToUserDTO(User user);
}
