package com.Bag.models.food;

import java.util.Map;

public class Food {

    private Map<String, Meal> meal;

    public Food(Map<String, Meal> meal) {
        this.meal = meal;
    }

    public Map<String, Meal> getMeal() {
        return meal;
    }

    public void setMeal(Map<String, Meal> meal) {
        this.meal = meal;
    }
}
