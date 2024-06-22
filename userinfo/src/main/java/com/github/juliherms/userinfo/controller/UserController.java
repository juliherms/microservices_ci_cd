package com.github.juliherms.userinfo.controller;

import com.github.juliherms.userinfo.dto.UserDTO;
import com.github.juliherms.userinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/")
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO userDTO) {
        UserDTO savedUser = service.save(userDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }
}
