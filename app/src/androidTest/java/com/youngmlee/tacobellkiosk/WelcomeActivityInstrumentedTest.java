package com.youngmlee.tacobellkiosk;

import android.content.Intent;

import com.youngmlee.tacobellkiosk.ui.OrderActivity;
import com.youngmlee.tacobellkiosk.ui.WelcomeActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.espresso.intent.rule.IntentsTestRule;

import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class WelcomeActivityInstrumentedTest {

    @Rule
    public IntentsTestRule<WelcomeActivity> intentsTestRule
            = new IntentsTestRule<>(WelcomeActivity.class);

    @Test
    public void startOrderByClickingLogoTest(){
        onView(withId(R.id.iv_live_mas_welcome)).perform(click());
        intended(hasComponent(OrderActivity.class.getName()));
    }

    @Test
    public void startOrderByClickingTextTest(){
        onView(withId(R.id.iv_tap_to_begin)).perform(click());
        intended(hasComponent(OrderActivity.class.getName()));

    }

    @Test
    public void startOrderByClickingWhiteSpaceTest(){
        onView(withId(R.id.cl_welcome)).perform(click());
        intended(hasComponent(OrderActivity.class.getName()));
    }
}
