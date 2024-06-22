package com.github.juliherms.foodcatalogue.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodItemDTO {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Long restaurantId;
    private Integer quantity;

}
