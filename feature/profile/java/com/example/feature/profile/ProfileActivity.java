package com.example.feature.profile;

import android.os.Bundle;
import android.widget.TextView;
import com.example.core.base.BaseActivity;
import com.example.domain.model.User;
import com.example.domain.usecase.GetUserUseCase;
import com.example.ui.widgets.RatingBarView;

/**
 * Profile screen Activity implemented in Java.
 * Inflates activity_profile.xml and populates the XML views.
 *
 * The XML layout (activity_profile.xml) references resources from:
 *  1. This module's own R:       R.layout.activity_profile, R.string.profile_title, R.drawable.bg_avatar_circle
 *  2. //core/resources module R: @color/brand_background, @color/text_secondary (in the layout)
 *  3. Material (maven) R:        ?attr/textAppearanceTitleMedium, ?attr/textAppearanceBodyMedium
 *
 * ProfileScreen.kt (in the same Bazel package) provides Compose @Preview composables.
 */
public class ProfileActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // R.layout.activity_profile — from THIS module's own resources
        setContentView(R.layout.activity_profile);
        setTitle(R.string.profile_title);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        GetUserUseCase useCase = new GetUserUseCase();
        User user = useCase.execute("current-user");
        bindUserToViews(user);
    }

    private void bindUserToViews(User user) {
        TextView tvName = findViewById(R.id.tv_name);
        TextView tvEmail = findViewById(R.id.tv_email);
        TextView tvEmailDetail = findViewById(R.id.tv_email_detail);
        TextView tvAvatar = findViewById(R.id.tv_avatar_placeholder);
        RatingBarView ratingBar = findViewById(R.id.rating_bar);

        tvName.setText(user.getName());
        tvEmail.setText(user.getEmail());
        tvEmailDetail.setText(user.getEmail());
        ratingBar.setRating(4.0f);

        // Show initials in avatar circle (bg_avatar_circle.xml uses @color/brand_primary
        // from //core/resources — a different Bazel module's resources)
        String[] parts = user.getName().split(" ");
        String initials = parts.length >= 2
            ? String.valueOf(parts[0].charAt(0)) + String.valueOf(parts[parts.length - 1].charAt(0))
            : String.valueOf(user.getName().charAt(0));
        tvAvatar.setText(initials.toUpperCase());
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}
