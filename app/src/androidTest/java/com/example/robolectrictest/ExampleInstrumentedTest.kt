package com.example.robolectrictest
import android.widget.TextView
import org.robolectric.Robolectric
import androidx.test.platform.app.InstrumentationRegistry
import org.robolectric.RobolectricTestRunner

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

@RunWith(RobolectricTestRunner::class)
class ExampleInstrumentedTest {
    @Test
    fun test_text_on_activity() {
        val activity = Robolectric.buildActivity(MainActivity::class.java).create().get()
        val text : TextView = activity.findViewById<TextView>(R.id.main_activity_text)
        assertEquals("Hello World!", text.text)
    }
}