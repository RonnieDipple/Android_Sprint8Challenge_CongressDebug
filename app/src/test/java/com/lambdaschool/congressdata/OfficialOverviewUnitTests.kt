package com.lambdaschool.congressdata

import org.junit.Test
import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldThrow
import java.lang.IllegalArgumentException
import kotlin.test.assertFails
import kotlin.test.assertFailsWith

class OfficialOverviewUnitTests {
    val testCorrect = OfficialOverview("Test FirstName", "Test MiddleName", "Test LastName", "Test Party", "Test State", "Test ID")
    val testFail = OfficialOverview("", "", "", "T", "", "")



    @Test
    fun TestCorrect() {

        testCorrect.party shouldEqual "Test Party"

        testCorrect.id shouldEqual "Test ID"

        testCorrect.state shouldEqual "Test State"

    }

   @Test
    fun testDisplayName(){

        testCorrect.displayName shouldEqual  "Test FirstName " + "Test MiddleName " + "Test LastName"
    }

   /*@Test
    fun shouldThrowException(){

        assertFailsWith(IllegalArgumentException::class){
            testFail shouldEqual null
        }
    }*/



}