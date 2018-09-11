package com.Bag.models.food;

import java.math.BigDecimal;
import java.util.Map;

public class Food {

    private Map<String, Meal> meal;
    private BigDecimal caloriesGoal;

    public Food(Map<String, Meal> meal) {
        this.meal = meal;
    }

    public Map<String, Meal> getMeal() {
        return meal;
    }

    public void setMeal(Map<String, Meal> meal) {
        this.meal = meal;
    }

    public BigDecimal getCaloriesGoal() {
        return caloriesGoal;
    }

    public void setCaloriesGoal(BigDecimal caloriesGoal) {
        this.caloriesGoal = caloriesGoal;
    }
}
