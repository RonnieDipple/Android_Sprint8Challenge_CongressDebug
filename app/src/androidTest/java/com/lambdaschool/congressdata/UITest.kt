package com.lambdaschool.congressdata

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters


@RunWith(AndroidJUnit4::class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class UITest {



        @Rule// junit test rule
        @JvmField// allows for compatibility with Kotlin
        var activityScenarioRule
                = ActivityScenarioRule(DetailsActivity::class.java)


        fun iHatePolticianscheck(){
            val name = "Trent P. Kelly"
            val party = "Republican"
            val District = "Mississippi - District 10"//would be better if it was District 9

            onView(withId(R.id.profile_name)).check(matches(withText(name)))


        }


        /*
        going to try to work out when a browser is launched but that is for later, maybe Kluent can help
        @Test
        fun linkTesting (){
            //Setup


            onView(withId(R.id.profile_twitter)).perform(click())
            assertTrue()


        }*/



}