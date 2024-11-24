package com.mealmap.foodcatalog.service;

import com.mealmap.foodcatalog.dto.FoodCatalogPage;
import com.mealmap.foodcatalog.dto.FoodItemDTO;
import com.mealmap.foodcatalog.dto.Restaurant;
import com.mealmap.foodcatalog.entity.FoodItem;
import com.mealmap.foodcatalog.mapper.FoodItemMapper;
import com.mealmap.foodcatalog.repo.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodCatalogService {

    @Autowired
    FoodItemRepo foodItemRepo;

    @Autowired
    RestTemplate template;

    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
        FoodItem foodItem = foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO));
        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(foodItem);
    }

    public FoodCatalogPage fetchRestaurantAndFoodMenu(Integer restaurantId) {
          Restaurant restaurant = fetchRestaurantDetailsFromRestaurantMS(restaurantId);
          List<FoodItemDTO> foodItems = fetchFoodItemsList(restaurantId);
          return createFoodCatalogPage(restaurant, foodItems);
    }

    private FoodCatalogPage createFoodCatalogPage(Restaurant restaurant, List<FoodItemDTO> foodItems) {
        FoodCatalogPage foodCatalogPage = new FoodCatalogPage();
        foodCatalogPage.setFoodItemsList(foodItems);
        foodCatalogPage.setRestaurant(restaurant);
        return foodCatalogPage;
    }

    private List<FoodItemDTO> fetchFoodItemsList(Integer restaurantId) {
        List<FoodItem> foodItems = foodItemRepo.findByRestaurantId(restaurantId);
        return foodItems.stream().map(foodItem -> FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(foodItem)).collect(Collectors.toList());
    }

    private Restaurant fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {
        return template.getForObject("http://RESTAURANTLISTING/restaurant/fetchById/"+restaurantId, Restaurant.class);
    }
}
