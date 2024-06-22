package com.github.juliherms.foodcatalogue.repositories;

import com.github.juliherms.foodcatalogue.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem,Long> {

    List<FoodItem> findByRestaurantId(Long restaurantId);
}
