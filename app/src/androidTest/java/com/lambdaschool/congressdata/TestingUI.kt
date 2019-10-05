package com.lambdaschool.congressdata

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@RunWith(AndroidJUnit4::class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestingUI {


    @Rule
    @JvmField
    var activityScenarioRule = ActivityScenarioRule(DetailsActivity::class.java)

    @Test
    fun iHatePoliticians() {


        val name = "Trent P. Kelly"
        val party = "Republican"
        val district = "Mississippi - District 10"
        val twitter = "Twitter"
        val facebook = "Facebook"
        val map = "1721 Longworth House Office Building"
        val phone = "202-225-4306"
        onView(withId(R.id.profile_name)).check(matches(withText(name)))
        onView(withId(R.id.profile_party)).check(matches(withText(party)))
        onView(withId(R.id.profile_district)).check(matches(withText(district)))
        onView(withId(R.id.profile_twitter)).check(matches(withText(twitter)))
        onView(withId(R.id.profile_facebook)).check(matches(withText(facebook)))
        onView(withId(R.id.profile_map)).check(matches(withText(map)))
        onView(withId(R.id.profile_phone)).check(matches(withText(phone)))


        //onView(withId(R.id.profile_name)).check(matches(withText(name)))
    }



}