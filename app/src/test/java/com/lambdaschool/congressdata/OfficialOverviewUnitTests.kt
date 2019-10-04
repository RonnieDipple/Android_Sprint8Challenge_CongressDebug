package com.lambdaschool.congressdata

import org.junit.Test
import org.mockito.Mockito.`when`
import kotlin.test.assertEquals
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldEqual

class OfficialOverviewUnitTests {
    val tested = OfficialOverview("Test FirstName", "Test MiddleName", "Test Lastname", "Test Party", "Test State", "Test id")


    @Test
    fun TestCorrect() {

        tested.party shouldEqual "Test Party"

        tested.id shouldEqual "Test id"

        tested.state shouldEqual "Test State"

    }

   @Test
    fun testDisplayName(){
        tested.displayName shouldEqual "test firstnametest middleName test lastname"
    }
}