package com.Bag.models.food;

import java.util.ArrayList;
import java.util.List;

public class Meal {

    List<Serving> servings;

    public Meal() {
        this.servings = new ArrayList<>();
    }

    public Meal(List<Serving> servings){
        this.servings = servings;
    }

    public void addServing(Serving serving){
        this.servings.add(serving);
    }

    public List<Serving> getServings() {
        return servings;
    }

    public void setServings(List<Serving> servings) {
        this.servings = servings;
    }
}
