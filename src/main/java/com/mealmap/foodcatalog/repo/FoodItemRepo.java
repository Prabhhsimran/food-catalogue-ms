package com.mealmap.foodcatalog.repo;

import com.mealmap.foodcatalog.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemRepo extends JpaRepository<FoodItem, Integer> {

    List<FoodItem> findByRestaurantId(Integer restaurantId);
}
