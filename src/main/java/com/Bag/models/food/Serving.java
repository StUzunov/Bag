package com.Bag.models.food;

import java.math.BigDecimal;

public class Serving {

    private ServingEnum servingEnum;
    private int quantity;
    private BigDecimal calories;

    public Serving(ServingEnum servingEnum, int quantity) {
        this.servingEnum = servingEnum;
        this.quantity = quantity;
        calculateCalories();
    }

    public ServingEnum getServingEnum() {
        return servingEnum;
    }

    private void calculateCalories(){
        this.calories = BigDecimal.valueOf(this.quantity).multiply(this.servingEnum.getCalories());
    }

    public void setServingEnum(ServingEnum servingEnum) {
        this.servingEnum = servingEnum;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getCalories() {
        return calories;
    }

    public void setCalories(BigDecimal calories) {
        this.calories = calories;
    }
}
