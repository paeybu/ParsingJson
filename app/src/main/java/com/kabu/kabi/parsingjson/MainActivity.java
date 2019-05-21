package com.kabu.kabi.parsingjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String candyJson = "{" +
                "\"candies\":[" +
                "{\"name\":\"Jelly Beans\"," +
                "\"count\":10}" +
                "]" +
                "}";
        try {
            JSONObject root = new JSONObject(candyJson);
            JSONArray candiesArray = root.getJSONArray("candies");

            JSONObject firstCandy = candiesArray.getJSONObject(0);

            String name = firstCandy.getString("name");
            int count = firstCandy.getInt("count");

            Log.v(LOG_TAG, "name = " + name + "\ncount = " + count);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
