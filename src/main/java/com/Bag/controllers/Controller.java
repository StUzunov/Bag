package com.Bag.controllers;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.List;

public abstract class Controller {

    String[] decodeBase64(List<String> authorization){
        String credentials = new String(Base64.getDecoder().decode(authorization.get(0).substring("Basic".length()).trim()), Charset.forName("UTF-8"));
        // credentials = username:password
        final String[] values = credentials.split(":",2);
        return values;
    }
}
