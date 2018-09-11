package com.Bag.models.water;

import java.math.BigDecimal;

public class DayWater {

    private int quantityGoal;
    private int quantity;
    private BigDecimal progress;

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

    public BigDecimal getProgress() {
        return progress;
    }

    public void setProgress(BigDecimal progress) {
        this.progress = progress;
    }
}
