package com.irfansaf.pucanteen.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.irfansaf.pucanteen.MainActivity;
import com.irfansaf.pucanteen.R;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth nAuth;
    ImageView backBtn;
    TextView registerFail;
    EditText name, email, password;
    Button registerBtn;
    String userName, userEmail, userPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nAuth = FirebaseAuth.getInstance();

        registerFail = findViewById(R.id.registFailed);
        registerFail.setVisibility(View.GONE);

        backBtn = findViewById(R.id.backButton);
        backBtn.setOnClickListener(v -> setBackBtn());

        name = findViewById(R.id.inputName);

        email = findViewById(R.id.inputEmail);

        password = findViewById(R.id.inputPassword);

        registerBtn = findViewById(R.id.registerButton);
        registerBtn.setOnClickListener(v -> registerAccount());
    }
    private void setBackBtn() {
        Intent back = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(back);
    }
    private void registerAccount() {
        userName = name.getText().toString();
        userEmail = email.getText().toString();
        userPassword = password.getText().toString();
        nAuth.createUserWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Intent registerSuccess = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(registerSuccess);
                    } else {
                        registerFail.setVisibility(View.VISIBLE);
                    }
                });

    }
}