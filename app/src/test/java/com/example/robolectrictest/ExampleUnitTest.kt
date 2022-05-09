package com.example.robolectrictest
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

@RunWith(RobolectricTestRunner::class)
class ExampleUnitTestTest {
    @Test
    fun test_text_on_activity() {
        val activity = Robolectric.buildActivity(MainActivity::class.java).create().get()
        val text : TextView = activity.findViewById<TextView>(R.id.main_activity_text)
        assertEquals("Hello World!", text.text)
    }

    @Test
    fun test_text_on_fragment(){
        val fragment = FirstFragment()

        val activity = Robolectric.buildActivity((
                SecondActivity::class.java
                ))
            .create()
            .start()
            .resume()
            .get()

        val fragmentManager: FragmentManager = activity.supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(fragment, null)
        fragmentTransaction.commit()

        val textView : TextView = activity.findViewById<TextView>(R.id.tv_hello_fragment)
        assertEquals("hello fragment", textView.text)
    }
}