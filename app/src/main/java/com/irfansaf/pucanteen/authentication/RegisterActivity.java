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
    EditText name, phone, email, password, major, batch;
    Button registerBtn;
    String userName, userEmail, userPassword, userPhone, userMajor, userBatch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nAuth = FirebaseAuth.getInstance();

        registerFail = findViewById(R.id.authFailed);
        registerFail.setVisibility(View.GONE);

        backBtn = findViewById(R.id.backButton);
        backBtn.setOnClickListener(v -> setBackBtn());

        name = findViewById(R.id.inputFullName);

        email = findViewById(R.id.inputEmail);

        password = findViewById(R.id.inputPassword);

        phone = findViewById(R.id.inputPhone);

        major = findViewById(R.id.inputMajor);

        batch = findViewById(R.id.inputBatch);

        registerBtn = findViewById(R.id.registerButton);
        registerBtn.setOnClickListener(v -> registerAccount());
    }
    private void setBackBtn() {
        finish();
    }
    private void registerAccount() {
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
    private void userData() {
        userName = name.getText().toString();
        userEmail = email.getText().toString();
        userPassword = password.getText().toString();
        userPhone = phone.getText().toString();
        userMajor = major.getText().toString();
        userBatch = batch.getText().toString();
    }
}