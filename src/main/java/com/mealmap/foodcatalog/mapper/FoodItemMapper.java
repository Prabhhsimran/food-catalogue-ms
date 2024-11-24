package com.mealmap.foodcatalog.mapper;

import com.mealmap.foodcatalog.dto.FoodItemDTO;
import com.mealmap.foodcatalog.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {

    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);

    FoodItemDTO mapFoodItemToFoodItemDTO(FoodItem foodItem);

    FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO);

}

