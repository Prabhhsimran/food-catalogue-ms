package com.mealmap.foodcatalog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodItemDTO {

    private int foodId;

    private String itemName;

    private String itemDescription;

    private boolean isVeg;

    private Number price;

    private Integer restaurantId;

    private Integer quantity;
}
