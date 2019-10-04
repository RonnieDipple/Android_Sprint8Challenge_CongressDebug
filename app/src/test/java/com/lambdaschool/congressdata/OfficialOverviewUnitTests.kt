package com.lambdaschool.congressdata

import org.junit.Test
import org.mockito.Mockito.`when`
import kotlin.test.assertEquals
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldNotEqual

class OfficialOverviewUnitTests {
    val tested = OfficialOverview("Test FirstName", "Test MiddleName", "Test LastName", "Test Party", "Test State", "Test ID")


    @Test
    fun TestCorrect() {

        tested.party shouldEqual "Test Party"

        tested.id shouldEqual "Test ID"

        tested.state shouldEqual "Test State"

    }

   @Test
    fun testDisplayName(){

        tested.displayName shouldEqual  "Test FirstName " + "Test MiddleName " + "Test LastName"
    }
}