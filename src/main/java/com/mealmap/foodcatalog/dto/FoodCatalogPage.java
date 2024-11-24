package com.mealmap.foodcatalog.dto;

import com.mealmap.foodcatalog.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCatalogPage {

    private List<FoodItemDTO> foodItemsList;
    private Restaurant restaurant;
}
