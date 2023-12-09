package com.irfansaf.pucanteen.authentication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.irfansaf.pucanteen.MainActivity;
import com.irfansaf.pucanteen.R;

public class LanguageActivity extends AppCompatActivity {
    CardView indonesianLang, englishLang;
    ImageView backBtn;
    private static String selectedLanguage = "en";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        indonesianLang = findViewById(R.id.indonesiaLanguage);
        indonesianLang.setOnClickListener(v -> setLocale("id"));

        englishLang = findViewById(R.id.englishLanguage);
        englishLang.setOnClickListener(v -> setLocale("en"));

        backBtn = findViewById(R.id.backButton);
        backBtn.setOnClickListener(v -> {
            Intent setBack = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(setBack);
        });
    }

    private void setLocale(String languageCode) {
        selectedLanguage = languageCode;
        updateUIText();

        // Use LocaleHelper to set the language
        Context updatedContext = LocaleHelper.setLocale(this, languageCode);
        recreateWithUpdatedContext(updatedContext);
    }

    private void recreateWithUpdatedContext(Context updatedContext) {
        finish();
        startActivity(new Intent(updatedContext, LanguageActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    private void updateUIText() {
        CardView indonesiaCardView = findViewById(R.id.indonesiaLanguage);
        CardView englishCardView = findViewById(R.id.englishLanguage);
        TextView indonesiaTextView = indonesiaCardView.findViewById(R.id.indonesiaText);
        TextView englishTextView = englishCardView.findViewById(R.id.englishText);
        indonesiaTextView.setText(getString(R.string.indonesia));
        englishTextView.setText(getString(R.string.english));
    }
}
