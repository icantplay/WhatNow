package com.example.whatnow.API;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class API_Spot {
    private static String url = "https://what--now.herokuapp.com";


    public static void getSpot(Queue queue, final VolleyCallback callback) {
        url += "/SpotInfo";

        JsonObjectRequest req = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                try {

                    Log.i("f", response.toString());
                    callback.onSuccess(response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("okok", "ENTROU ");
                        System.out.println(error);
                    }
                });


        queue.addToRequestQueue(req);
    }
}
