package com.example.pucanteen.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.pucanteen.R;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth nAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nAuth = FirebaseAuth.getInstance();
    }
}