package com.example.alimentos.busines;

import com.example.alimentos.entity.FoodEntity;
import com.example.alimentos.repositorie.FoodRepository;

import java.util.List;

public class FoodBusines {
    public FoodEntity getFood(int id){
        return new FoodRepository().getFood(id);
    }
    public List<FoodEntity> getList(){
        return new FoodRepository().getList();
    }
}
