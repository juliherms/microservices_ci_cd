package com.github.juliherms.restaurantlisting.service;

import com.github.juliherms.restaurantlisting.dto.RestaurantDTO;
import com.github.juliherms.restaurantlisting.entity.Restaurant;
import com.github.juliherms.restaurantlisting.mapper.RestaurantMapper;
import com.github.juliherms.restaurantlisting.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository repo;

    public List<RestaurantDTO> listAll() {
        List<Restaurant> restaurants = repo.findAll();
        return restaurants
                .stream()
                .map(RestaurantMapper.INSTANCE::mapRestaurantToRestaurantDTO)
                .collect(Collectors.toList());
    }

    public RestaurantDTO save(RestaurantDTO restaurantDTO) {
        Restaurant savedRestaurant = repo.save(RestaurantMapper.INSTANCE.mapRestaurantDTOtoRestaurant(restaurantDTO));
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(savedRestaurant);
    }

    public ResponseEntity<RestaurantDTO> findById(Long id) {
        Optional<Restaurant> restaurant = repo.findById(id);
        return restaurant.map(value -> new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(value), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}
