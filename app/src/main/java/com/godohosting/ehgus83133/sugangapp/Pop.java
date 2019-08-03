package com.godohosting.ehgus83133.sugangapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.util.Linkify;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pop extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * 0.9), (int) (height * 0.85));

        TextView github = (TextView) findViewById(R.id.github);

        Linkify.TransformFilter mTransform = new Linkify.TransformFilter() {
            @Override
            public String transformUrl(Matcher match, String url) {
                return "";
            }
        };

        Pattern pattern1 = Pattern.compile("https://github.com/ehgus8313");


        Linkify.addLinks(github, pattern1, "https://github.com/ehgus8313",null,mTransform);
    }
}
