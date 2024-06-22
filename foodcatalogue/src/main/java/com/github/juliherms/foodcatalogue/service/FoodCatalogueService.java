package com.github.juliherms.foodcatalogue.service;

import com.github.juliherms.foodcatalogue.dto.FoodCataloguePage;
import com.github.juliherms.foodcatalogue.dto.FoodItemDTO;
import com.github.juliherms.foodcatalogue.dto.Restaurant;
import com.github.juliherms.foodcatalogue.entity.FoodItem;
import com.github.juliherms.foodcatalogue.mapper.FoodItemMapper;
import com.github.juliherms.foodcatalogue.repositories.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodCatalogueService {

    @Autowired
    FoodItemRepository repo;

    @Autowired
    RestTemplate restTemplate;

    public FoodItemDTO save(FoodItemDTO foodItemDTO) {
        FoodItem foodItemSaved = repo.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO));
        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(foodItemSaved);
    }

    public FoodCataloguePage findByRestaurant(Long restaurantId) {

        // obtém a lista de itens do restaurante informado
        List<FoodItem> foodItemList = fetchFoodItemList(restaurantId);
        // obtém os detalhes do restaurante de um ms externo
        Restaurant restaurant = fetchRestaurantDetails(restaurantId);
        // cria de fato o registro no banco de dados
        return createFoodCataloguePage(foodItemList,restaurant);
    }

    private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant){
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage(foodItemList,restaurant);
        return foodCataloguePage;
    }

    private Restaurant fetchRestaurantDetails(Long restaurantId) {
       return restTemplate.getForObject("http://RESTAURANT-SERVICE/"+ restaurantId, Restaurant.class);
    }

    private List<FoodItem> fetchFoodItemList(Long restaurantId) {
        return repo.findByRestaurantId(restaurantId);
    }
}
