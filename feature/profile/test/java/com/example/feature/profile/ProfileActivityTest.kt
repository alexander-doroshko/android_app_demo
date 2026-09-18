package com.example.feature.profile

import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ProfileActivityTest {

    @Test
    fun activityCreatesSuccessfully() {
        val controller = Robolectric.buildActivity(ProfileActivity::class.java)
        controller.create().start().resume()
        assertNotNull(controller.get())
    }

    @Test
    fun activityHasNonNullTitle() {
        val controller = Robolectric.buildActivity(ProfileActivity::class.java)
        val activity = controller.create().start().resume().get()
        assertNotNull(activity.title)
    }
}
