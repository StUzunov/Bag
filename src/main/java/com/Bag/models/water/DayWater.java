package com.Bag.models.water;

public class DayWater {

    private int quantityGoal;
    private int quantity;

    public DayWater(int quantityGoal) {
        this.quantityGoal = quantityGoal;
    }

    public int getQuantityGoal() {
        return quantityGoal;
    }

    public void setQuantityGoal(int quantityGoal) {
        this.quantityGoal = quantityGoal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
