package com.example.alimentos.repositorie;

import com.example.alimentos.entity.FoodEntity;

import java.util.ArrayList;
import java.util.List;

public class FoodRepository {
    List<FoodEntity> mListFood;

    public FoodRepository() {
        this.mListFood = new ArrayList<>();
        this.mListFood.add(new FoodEntity("Cenoura", 35,100,"g","Este alimento contém vitamina A,B,C,D"));
        this.mListFood.add(new FoodEntity("Maçã", 52,100,"g","Este alimento contém vitamina A,B,C,D"));
        this.mListFood.add(new FoodEntity("Arroz", 130,100,"g","Este alimento contém vitamina A,B,C,D"));
        this.mListFood.add(new FoodEntity("Feijão", 160,100,"g","Este alimento contém vitamina A,B,C,D"));
        this.mListFood.add(new FoodEntity("Frango", 165,100,"g","Este alimento contém vitamina A,B,C,D"));
        this.mListFood.add(new FoodEntity("Pão Integral",100,79,"g","Este alimento contém vitamina A,B,C,D" ));
        this.mListFood.add(new FoodEntity("Iogurte", 80,100,"g","Este alimento contém vitamina A,B,C,D"));
        this.mListFood.add(new FoodEntity("Batata Doce",100,7,"g","Este alimento contém vitamina A,B,C,D"));
        this.mListFood.add(new FoodEntity("Salmão", 206,100,"g","Este alimento contém vitamina A,B,C,D"));
        this.mListFood.add(new FoodEntity("Abacaxi", 50,100,"g","Este alimento contém vitamina A,B,C,D"));
        this.mListFood.add(new FoodEntity("Brócolis", 55,100,"g","Este alimento contém vitamina A,B,C,D"));
        this.mListFood.add(new FoodEntity("Aveia", 150,100,"g","Este alimento contém vitamina A,B,C,D"));
        this.mListFood.add(new FoodEntity("Banana", 105,100,"g","Este alimento contém vitamina A,B,C,D"));
        this.mListFood.add(new FoodEntity("Tomate", 18,100,"g","Este alimento contém vitamina A,B,C,D"));
        this.mListFood.add(new FoodEntity("Cebola", 40,100,"g","Este alimento contém vitamina A,B,C,D"));
    }

    public FoodEntity getFood(int id){
        return this.mListFood.get(id);
    }
    public  List<FoodEntity> getList(){
        return this.mListFood;
    }
}
