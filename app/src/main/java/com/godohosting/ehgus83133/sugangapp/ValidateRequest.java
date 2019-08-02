package com.godohosting.ehgus83133.sugangapp;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ehgus on 2018-03-11.
 */

public class ValidateRequest extends StringRequest {

    final static private String URL = "http://ehgus83133.godohosting.com/UserValidate.php";
    private Map<String, String> parameters;
    public ValidateRequest(String userID, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userID", userID);
    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }
}
