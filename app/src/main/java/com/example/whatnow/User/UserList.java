package com.example.whatnow.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.whatnow.API.API_UserList;
import com.example.whatnow.API.Queue;
import com.example.whatnow.API.VolleyCallback;
import com.example.whatnow.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UserList extends AppCompatActivity {
    RecyclerView userRecyclerView;
    private List<User> user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        user = new ArrayList<>();
        userRecyclerView = findViewById(R.id.recyclerView);
        getUsername();
    }
    private void getUsername() {

        final VolleyCallback callback = new VolleyCallback() {
            @Override
            public void onSuccess(JSONObject result) throws JSONException {
                try {
                    JSONArray jsonArray = result.getJSONArray("data");
                    for (int i =0;i < jsonArray.length();i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        user.add(new User(jsonObject.getString("Name"),jsonObject.getInt("id")));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Usersetuprecyclerview(user);
            }
            @Override
            public void onError(String result) {
                Log.i("oi", "Erro");
            }
        };
        API_UserList.getUsername(Queue.getInstance(getApplicationContext()), callback);
    }
    private void Usersetuprecyclerview(List<User> events) {
        Usermyadapter myAdapter = new Usermyadapter(this,user);
        userRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        userRecyclerView.setAdapter(myAdapter);


    }
}
