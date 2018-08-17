package com.Bag.models.food;

import java.math.BigDecimal;

public enum  ServingEnum {

    RICE(BigDecimal.valueOf(1.3)),
    CHICKEN_BREAST(BigDecimal.valueOf(1.649));

    private final BigDecimal calories;
    ServingEnum(BigDecimal calories) { this.calories = calories; }

    public BigDecimal getCalories() { return calories; }

}
