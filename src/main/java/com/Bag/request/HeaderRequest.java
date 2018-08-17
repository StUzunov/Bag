package com.Bag.request;

public class HeaderRequest implements Validated {

    private String username;
    private String password;

    public HeaderRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public ValidationResponse validate() {
        //todo
        return ValidationResponse.OK;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
