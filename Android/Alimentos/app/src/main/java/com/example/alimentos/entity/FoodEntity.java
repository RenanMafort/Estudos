package com.example.alimentos.entity;

import java.util.UUID;

public class FoodEntity {
    private static int id = 0;
    private String name;
    private int calories;
    private int quantity;
    private String unit;
    private String description;

    public int getId() {
        return id;
    }

    public FoodEntity(String name,int calories, int quantity, String unit, String description) {
        id++;
        this.calories = calories;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
