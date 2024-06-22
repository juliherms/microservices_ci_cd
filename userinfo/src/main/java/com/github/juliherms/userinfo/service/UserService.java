package com.github.juliherms.userinfo.service;

import com.github.juliherms.userinfo.dto.UserDTO;
import com.github.juliherms.userinfo.entity.User;
import com.github.juliherms.userinfo.mapper.UserMapper;
import com.github.juliherms.userinfo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public UserDTO save(UserDTO userDTO) {
        User savedUser = repo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
        return UserMapper.INSTANCE.mapUserToUserDTO(savedUser);
    }

    public ResponseEntity<UserDTO> findById(Long id) {
        Optional<User> userFound = repo.findById(id);
        return userFound.map(user -> new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(user), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}
