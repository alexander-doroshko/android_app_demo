package com.example.feature.settings;

import org.junit.Test;
import static org.junit.Assert.*;

public class SettingsHelperTest {

    private final SettingsHelper helper = new SettingsHelper();

    @Test
    public void isValidUsername_emptyReturnsFalse() {
        assertFalse(helper.isValidUsername(""));
    }

    @Test
    public void isValidUsername_singleCharReturnsFalse() {
        assertFalse(helper.isValidUsername("a"));
    }

    @Test
    public void isValidUsername_validNameReturnsTrue() {
        assertTrue(helper.isValidUsername("Alice"));
    }

    @Test
    public void isValidUsername_twoCharReturnsTrue() {
        assertTrue(helper.isValidUsername("Al"));
    }
}
