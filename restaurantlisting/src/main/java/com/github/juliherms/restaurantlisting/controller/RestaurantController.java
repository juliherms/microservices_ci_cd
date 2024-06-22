package com.github.juliherms.restaurantlisting.controller;

import com.github.juliherms.restaurantlisting.dto.RestaurantDTO;
import com.github.juliherms.restaurantlisting.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    RestaurantService service;

    @GetMapping("/")
    public ResponseEntity<List<RestaurantDTO>> listAll() {
        List<RestaurantDTO> restaurants = service.listAll();
        return new ResponseEntity<>(restaurants, HttpStatus.OK) ;
    }

    @PostMapping("/")
    public ResponseEntity<RestaurantDTO> save(@RequestBody RestaurantDTO restaurantDTO) {
        RestaurantDTO restaurantAdded = service.save(restaurantDTO);
        return new ResponseEntity<>(restaurantAdded,HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<RestaurantDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }
}
