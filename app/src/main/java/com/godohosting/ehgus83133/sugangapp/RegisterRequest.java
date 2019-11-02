package com.godohosting.ehgus83133.sugangapp;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ehgus on 2018-03-14.
 */

public class RegisterRequest extends StringRequest {
    final static private String URL = "http://ehgus83133.godohosting.com/Register.php";
    private Map<String, String> parameters;

    public RegisterRequest(String userID, String userPassword, String userName, String userEmail, String userGender, String userMajor, String admin, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userID", userID);
        parameters.put("userPassword", userPassword);
        parameters.put("userName", userName);
        parameters.put("userEmail", userEmail);
        parameters.put("userGender", userGender);
        parameters.put("userMajor", userMajor);
        parameters.put("admin", admin);
    }


    @Override
    public Map<String, String> getParams() {
        return parameters;
    }

}
