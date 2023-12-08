
package com.example.pucanteen.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pucanteen.MainActivity;
import com.example.pucanteen.R;
import com.example.pucanteen.homepage.HomepageActivity;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    ImageView backBtn;
    EditText email, password;
    TextView authFail, signUp;
    Button loginBtn;
    private FirebaseAuth nAuth;
    private String checkEmail, checkPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nAuth = FirebaseAuth.getInstance();

        backBtn = findViewById(R.id.backButton);
        backBtn.setOnClickListener(v -> setBackBtn());

        email = findViewById(R.id.inputEmail);

        password = findViewById(R.id.inputPassword);

        authFail = findViewById(R.id.authFailed);
        authFail.setVisibility(View.GONE);

        signUp = findViewById(R.id.SignUp);
        signUp.setOnClickListener(v -> setSignUp());

        loginBtn = findViewById(R.id.loginButton);
        loginBtn.setOnClickListener(v -> authentication());
    }
    private void authentication() {
        checkEmail = email.getText().toString();
        checkPassword = password.getText().toString();
        nAuth.signInWithEmailAndPassword(checkEmail, checkPassword)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Intent authSuccess = new Intent(getApplicationContext(), HomepageActivity.class);
                        startActivity(authSuccess);
                    } else {
                        authFail.setVisibility(View.VISIBLE);
                    }
                });
    }
    private void setSignUp() {
        Intent signUpAccount = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(signUpAccount);
    }
    private void setBackBtn() {
        Intent back = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(back);
    }
}