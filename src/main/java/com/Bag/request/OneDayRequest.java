package com.Bag.request;

public class OneDayRequest implements Validated {

    String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public ValidationResponse validate() {
        //todo
        return ValidationResponse.OK;
    }
}