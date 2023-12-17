package com.irfansaf.pucanteen.user;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.irfansaf.pucanteen.R;

public class EditProfile extends AppCompatActivity {
    ImageView backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        backBtn = findViewById(R.id.backButton);
        backBtn.setOnClickListener(view -> setbackBtn());
    }
    private void setbackBtn(){
        backBtn.setOnClickListener(view -> finish());
    }
}