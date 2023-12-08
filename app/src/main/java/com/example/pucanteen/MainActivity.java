package com.example.pucanteen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pucanteen.authentication.LoginActivity;
import com.example.pucanteen.authentication.RegisterActivity;

public class MainActivity extends AppCompatActivity {
    Button loginBtn, registerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = findViewById(R.id.loginButton);
        loginBtn.setOnClickListener(v -> {
            Intent loginApp = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(loginApp);
        });

        registerBtn = findViewById(R.id.registerButton);
        registerBtn.setOnClickListener(v -> {
            Intent registerApp = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(registerApp);
        });
    }
}