package com.suleiman.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {

    public static final String KEY_THEME = "key_theme_change";
    private static final String PREFS = "prefs.xml";
    private static final String PREF_NAME = "theme";
    private static final String KEY = "key_save";

    private Switch mSwitchTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        boolean isNightTheme = getSharedPreferences(PREFS, MODE_PRIVATE).getBoolean(PREF_NAME, false);

        if (isNightTheme) {
            setTheme(R.style.Theme_dark_calculator);
        } else {
            setTheme(R.style.Theme_calculator);
        }

        setContentView(R.layout.activity_settings);

        mSwitchTheme = findViewById(R.id.theme_change);
        mSwitchTheme.setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked) -> {
            SharedPreferences sharedPreferences = getSharedPreferences(PREFS, MODE_PRIVATE);
            if (sharedPreferences.getBoolean(PREF_NAME, false) != isChecked) {
                sharedPreferences.edit().putBoolean(PREF_NAME, isChecked).apply();
                Intent intent = new Intent();
                intent.putExtra(KEY_THEME, isChecked);
                recreate();
            }
        });
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedState) {
        super.onRestoreInstanceState(savedState);
        if (savedState != null) {
            android.util.Log.d(KEY, "Entered if SavedState");
            mSwitchTheme.setChecked(savedState.getBoolean(KEY));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle state) {
        super.onSaveInstanceState(state);
        state.putBoolean(KEY, mSwitchTheme.isChecked());
    }
}