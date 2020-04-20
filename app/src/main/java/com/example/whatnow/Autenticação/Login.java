package com.example.whatnow.Autenticação;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.whatnow.R;
import com.example.whatnow.Evento.Principal;

public class Login extends AppCompatActivity {
    private Button btnLogin;
    private Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegisto();
            }
        });
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPrincipal();
            }
        });
    }

    private void openRegisto() {
        Intent intent = new Intent(this, Registo.class);
        startActivity(intent);

    }
    private void openPrincipal(){

        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }
}
