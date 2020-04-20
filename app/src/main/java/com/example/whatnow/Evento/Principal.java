package com.example.whatnow.Evento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.whatnow.API.API_Eventos;
import com.example.whatnow.API.Queue;
import com.example.whatnow.R;
import com.example.whatnow.API.VolleyCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Principal extends AppCompatActivity {

    RecyclerView recyclerView;
    private List<EventInfo> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        events = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        recyclerView = findViewById(R.id.recyclerView);

        getEventoInfo();
    }
    private void getEventoInfo() {

        final VolleyCallback callback = new VolleyCallback() {
            @Override
            public void onSuccess(JSONObject result) throws JSONException {
                try {
                    JSONArray jsonArray = result.getJSONArray("data");
                    for (int i =0;i < jsonArray.length();i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        events.add(new EventInfo(jsonObject.getString("Name"),jsonObject.getString("DateStart"),jsonObject.getString("DateEnd"),jsonObject.getString("Description")));
                    }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                setuprecyclerview(events);
            }
            @Override
            public void onError(String result) {
                Log.i("oi", "Erro");
            }
        };
        API_Eventos.getEventos(Queue.getInstance(getApplicationContext()), callback);
    }

    private void setuprecyclerview(List<EventInfo> events) {
    MyAdapter myAdapter = new MyAdapter(this,events);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(myAdapter);


    }


}
