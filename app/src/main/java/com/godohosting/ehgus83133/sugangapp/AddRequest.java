package com.godohosting.ehgus83133.sugangapp;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ehgus on 2018-03-14.
 */

public class AddRequest extends StringRequest {
    final static private String URL = "http://ehgus83133.godohosting.com/CourseAdd.php";
    private Map<String, String> parameters;

    public AddRequest(String userID, String courseID, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userID", userID);
        parameters.put("courseID", courseID);
    }


    @Override
    public Map<String, String> getParams() {
        return parameters;
    }

}
