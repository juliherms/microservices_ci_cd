package com.github.juliherms.restaurantlisting.mapper;

import com.github.juliherms.restaurantlisting.dto.RestaurantDTO;
import com.github.juliherms.restaurantlisting.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    Restaurant mapRestaurantDTOtoRestaurant(RestaurantDTO restaurantDTO);

    RestaurantDTO mapRestaurantToRestaurantDTO(Restaurant restaurant);
}
