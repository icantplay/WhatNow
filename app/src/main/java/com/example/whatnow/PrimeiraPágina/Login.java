package com.example.whatnow.PrimeiraPágina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.whatnow.R;
import com.example.whatnow.TypeofSpace;
import com.example.whatnow.User.UserList;

public class Login extends AppCompatActivity {
    private Button btnLogin;
    private Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegister = findViewById(R.id.btnPingTest);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUserList();
            }
        });
        btnLogin = findViewById(R.id.btnAplicação);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTypeofSpace();
            }
        });
    }

    private void openUserList() {
        Intent intent = new Intent(this, UserList.class);
        startActivity(intent);

    }
    private void openTypeofSpace(){

        Intent intent = new Intent(this, TypeofSpace.class);
        startActivity(intent);
    }
}
