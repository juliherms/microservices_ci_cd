package com.github.juliherms.restaurantlisting.repositories;

import com.github.juliherms.restaurantlisting.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
}
