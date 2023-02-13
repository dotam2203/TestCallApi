package com.test

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
 class  ExampleUnitTest {
    /*@Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 3)
    }*/
    @Test
    fun generates_number(){
        val dice = Dice(4)
        val rollResult = dice.roll()
        assertTrue("The value of rollResult was not between 1 and 6",rollResult in 1..6)
    }
}
class Dice (private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}