package com.example.whatnow.API;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class API_Ping {
    private static String url = "https://what--now.herokuapp.com";
    public static void postcoordenadas(int id,double longitude,double latitude , Queue queue, final VolleyCallback callback) throws JSONException {
        url += "/Loghistory";






        String dados ="{\"id\":"+id+",\"coordinates\":{\"x\":"+longitude+",\"y\":"+latitude+"}}";

        JSONObject object = new JSONObject(dados);
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,url, object, new Response.Listener<JSONObject>() {

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
                        try {
                            callback.onError(error.toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println(error);
                    }
                });




        queue.addToRequestQueue(req);
    }
}
