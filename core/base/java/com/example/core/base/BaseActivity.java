package com.example.core.base;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Base Activity for all activities in the app.
 * Extends AppCompatActivity — the AppCompat library provides resources like
 * Theme.AppCompat, abc_* strings, etc., which are accessed via the maven-provided R class
 * (androidx.appcompat.R).
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void showLoading() {
        // Subclasses can override to show a loading indicator.
        // Uses R.string.base_loading from this module's own resources.
        setTitle(getString(R.string.base_loading));
    }

    protected void showError(String message) {
        // In a real app, this would show a Snackbar or Dialog.
        android.util.Log.e("BaseActivity", message);
    }
}
