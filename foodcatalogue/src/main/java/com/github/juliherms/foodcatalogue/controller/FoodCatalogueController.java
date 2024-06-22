package com.github.juliherms.foodcatalogue.controller;

import com.github.juliherms.foodcatalogue.dto.FoodCataloguePage;
import com.github.juliherms.foodcatalogue.dto.FoodItemDTO;
import com.github.juliherms.foodcatalogue.service.FoodCatalogueService;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodCatalogue")
public class FoodCatalogueController {

    @Autowired
    FoodCatalogueService service;

    @PostMapping("/")
    public ResponseEntity<FoodItemDTO> save(@RequestBody FoodItemDTO foodItemDTO) {
        FoodItemDTO foodItemSaved = service.save(foodItemDTO);
        return new ResponseEntity<>(foodItemSaved, HttpStatus.CREATED);
    }

    public ResponseEntity<FoodCataloguePage> findByRestaurant(@PathVariable Long restaurantId) {
        FoodCataloguePage foodCataloguePage = service.findByRestaurant(restaurantId);
        return new ResponseEntity<>(foodCataloguePage, HttpStatus.OK);
    }


}
