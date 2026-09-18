package com.example.feature.settings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class SettingsActivityTest {

    @Test
    public void activityCreatesSuccessfully() {
        ActivityController<SettingsActivity> controller =
            Robolectric.buildActivity(SettingsActivity.class);
        controller.create().start().resume();
        assertNotNull(controller.get());
        controller.destroy();
    }

    @Test
    public void activityHasCorrectTitle() {
        ActivityController<SettingsActivity> controller =
            Robolectric.buildActivity(SettingsActivity.class);
        SettingsActivity activity = controller.create().start().resume().get();
        // Title comes from R.string.settings_title in this module's own resources
        assertNotNull(activity.getTitle());
        controller.destroy();
    }
}
