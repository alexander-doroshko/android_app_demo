package com.example.feature.settings;

import android.os.Bundle;
import android.widget.Toast;
import com.example.core.base.BaseActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;

/**
 * Settings screen implemented in Java using XML layouts.
 * Demonstrates:
 *  - Java Activity extending BaseActivity (core/base module)
 *  - Using R from THIS module (R.layout.activity_settings, R.string.settings_title, etc.)
 *  - Using Material Components (maven R resources for Material themes/styles)
 */
public class SettingsActivity extends BaseActivity {

    private SwitchMaterial switchDarkTheme;
    private TextInputEditText etUsername;
    private MaterialButton btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // R.layout.activity_settings — from THIS module's own resources
        setContentView(R.layout.activity_settings);
        setTitle(R.string.settings_title);

        switchDarkTheme = findViewById(R.id.switch_dark_theme);
        etUsername = findViewById(R.id.et_username);
        btnSave = findViewById(R.id.btn_save);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        btnSave.setOnClickListener(v -> onSaveClicked());
    }

    private void onSaveClicked() {
        String username = etUsername.getText() != null
            ? etUsername.getText().toString().trim()
            : "";

        boolean isDarkTheme = switchDarkTheme.isChecked();

        // In a real app, persist these via ViewModel/DataStore
        SettingsHelper helper = new SettingsHelper();
        helper.applySettings(username, isDarkTheme);

        Toast.makeText(this, R.string.settings_saved_confirmation, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}
