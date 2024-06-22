package com.github.juliherms.foodcatalogue.dto;

import com.github.juliherms.foodcatalogue.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FoodCataloguePage {

    public  FoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
        this.foodItemsList = foodItemList;
        this.restaurant = restaurant;
    }

    private List<FoodItem> foodItemsList;
    private Restaurant restaurant;
}
