package com.example.whatnow.Spot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.whatnow.API.API_Spot;
import com.example.whatnow.API.Queue;
import com.example.whatnow.API.VolleyCallback;
import com.example.whatnow.Evento.MyAdapter;
import com.example.whatnow.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Spots extends AppCompatActivity {
    RecyclerView recyclerView;
    private List<SpotInfo> spots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        spots = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spots);
        recyclerView = findViewById(R.id.recyclerView);
        getSpotInfo();
    }
    private void getSpotInfo() {

        final VolleyCallback callback = new VolleyCallback() {
            @Override
            public void onSuccess(JSONObject result) throws JSONException {
                try {
                    JSONArray jsonArray = result.getJSONArray("data");
                    for (int i =0;i < jsonArray.length();i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        spots.add(new SpotInfo(jsonObject.getString("Name"),jsonObject.getString("Contact"),jsonObject.getString("Description"),jsonObject.getString("Street"),jsonObject.getString("PostalCode"),jsonObject.getString("Town"),jsonObject.getString("Country")));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                setuprecyclerview(spots);
            }
            @Override
            public void onError(String result) {
                Log.i("oi", "Erro");
            }
        };
        API_Spot.getSpot(Queue.getInstance(getApplicationContext()), callback);
    }

    private void setuprecyclerview(List<SpotInfo> spots) {
        SpotAdapter myAdapter = new SpotAdapter(this,spots);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);


    }

}
