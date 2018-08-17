package com.Bag.models;

import org.springframework.security.core.GrantedAuthority;


public class CustomRole implements GrantedAuthority {
    String role = null;

    @Override
    public String getAuthority() {
        return role;
    }

    public void setAuthority(String roleName) {
        this.role = roleName;
    }

}