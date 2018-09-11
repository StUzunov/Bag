package com.Bag.engine.challenge;

import java.math.BigDecimal;

public class CaloriesGenerator implements Generator{

    @Override
    public Object generate(Object object) {
        return new BigDecimal(2000);
    }
}
