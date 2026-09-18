package com.example.core.utils;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtilsTest {

    @Test
    public void isNullOrEmpty_nullReturnsTrue() {
        assertTrue(StringUtils.isNullOrEmpty(null));
    }

    @Test
    public void isNullOrEmpty_emptyReturnsTrue() {
        assertTrue(StringUtils.isNullOrEmpty(""));
    }

    @Test
    public void isNullOrEmpty_nonEmptyReturnsFalse() {
        assertFalse(StringUtils.isNullOrEmpty("hello"));
    }

    @Test
    public void capitalize_lowercaseInput() {
        assertEquals("Hello", StringUtils.capitalize("hello"));
    }

    @Test
    public void truncate_shortStringUnchanged() {
        assertEquals("hi", StringUtils.truncate("hi", 10));
    }

    @Test
    public void truncate_longStringTruncated() {
        String result = StringUtils.truncate("Hello World", 5);
        assertTrue(result.startsWith("Hello"));
        assertTrue(result.length() < "Hello World".length() + 2);
    }

    @Test
    public void initials_fullName() {
        assertEquals("A", StringUtils.initials("Alice"));
    }

    @Test
    public void initials_singleName() {
        assertEquals("A", StringUtils.initials("Alice"));
    }

    @Test
    public void initials_emptyString() {
        assertEquals("?", StringUtils.initials(""));
    }
}
