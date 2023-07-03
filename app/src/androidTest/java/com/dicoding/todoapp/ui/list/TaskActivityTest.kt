package com.dicoding.todoapp.ui.list

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dicoding.todoapp.R
import com.dicoding.todoapp.ui.add.AddTaskActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

//TODO 16 : Write UI test to validate when user tap Add Task (+), the AddTaskActivity displayed
@RunWith(AndroidJUnit4::class) // Using JUnit4
class TaskActivityTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(TaskActivity::class.java)

    @Test
    fun validateAddTaskActivityDisplayed() {
        Intents.init() // Initialize Intents for capturing and verifying intents

        // Perform a click on the FloatingActionButton (fab) in the TaskActivity
        Espresso.onView(ViewMatchers.withId(R.id.fab)).perform(ViewActions.click())

        // Verify that an intent to launch AddTaskActivity is sent
        Intents.intended(IntentMatchers.hasComponent(AddTaskActivity::class.java.name))

        Intents.release() // Release Intents resources
    }
}