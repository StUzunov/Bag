package com.Bag.request.user;

import com.Bag.request.Validated;
import com.Bag.request.ValidationResponse;

public class CreateNewBagUserRequest implements Validated {

    private String username;
    private String password;
    private String fName;
    private String lName;
    private String email;

    @Override
    public ValidationResponse validate() {
        //TODO add good validation
        if(fName.isEmpty()){
            return new ValidationResponse(false, "First name is empty!");
        }
        return ValidationResponse.OK;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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