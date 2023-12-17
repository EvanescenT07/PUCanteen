package com.irfansaf.pucanteen.authentication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.irfansaf.pucanteen.MainActivity;
import com.irfansaf.pucanteen.R;
import com.irfansaf.pucanteen.homepage.HomepageActivity;

public class LoginActivity extends AppCompatActivity {
    ImageView backBtn;
    EditText email, password;
    TextView authFail, signUp;
    Button loginBtn;
    private FirebaseAuth nAuth;
    private boolean passwordVisible = false;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nAuth = FirebaseAuth.getInstance();

        backBtn = findViewById(R.id.backButton);
        backBtn.setOnClickListener(v -> setBackBtn());

        email = findViewById(R.id.inputEmail);

        password = findViewById(R.id.inputPassword);
        password.setOnTouchListener((v, event) -> {
            final int DRAWABLE_RIGHT = 2;
            if (event.getAction() == MotionEvent.ACTION_UP) {
                if (event.getRawX() >= (password.getRight() - password.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                    togglePasswordVisibility();
                    return true;
                }
            }
            return false;
        });

        authFail = findViewById(R.id.authFailed);
        authFail.setVisibility(View.GONE);

        signUp = findViewById(R.id.signUpButton);
        signUp.setOnClickListener(v -> setSignUp());

        loginBtn = findViewById(R.id.loginButton);
        loginBtn.setOnClickListener(v -> authentication());
    }
    private void authentication() {
        String checkEmail = email.getText().toString();
        String checkPassword = password.getText().toString();
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
    private void togglePasswordVisibility() {
        if (passwordVisible) {
            password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        } else {
            password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
        passwordVisible = !passwordVisible;
        password.setSelection(password.getText().length());
    }
}
