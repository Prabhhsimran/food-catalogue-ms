package com.mealmap.foodcatalog.controller;

import com.mealmap.foodcatalog.dto.FoodCatalogPage;
import com.mealmap.foodcatalog.dto.FoodItemDTO;
import com.mealmap.foodcatalog.service.FoodCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodCatalog")
@CrossOrigin
public class FoodCatalogController {

    @Autowired
    FoodCatalogService foodCatalogService;

    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO){
        FoodItemDTO addedFoodItem = foodCatalogService.addFoodItem(foodItemDTO);
        return new ResponseEntity<>(addedFoodItem, HttpStatus.CREATED);
    }

    @GetMapping("/fetchRestaurantAndFoodItemsById/{restaurantId}")
    public ResponseEntity<FoodCatalogPage> fetchRestaurantAndFoodMenu(@PathVariable Integer restaurantId){
        FoodCatalogPage foodCatalogPage =  foodCatalogService.fetchRestaurantAndFoodMenu(restaurantId);
        return new ResponseEntity<>(foodCatalogPage, HttpStatus.OK);
    }

}
