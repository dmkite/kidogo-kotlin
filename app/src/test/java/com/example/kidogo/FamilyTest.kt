package com.example.kidogo

import junit.framework.TestCase
import org.junit.Test
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import java.time.LocalDate
import java.util.*

class FamilyTest : TestCase() {
    private val children = mutableListOf<Child>()
    private val guardian: Guardian = mock()
    private val emergencyContact: EmergencyContact = mock()
    private val family = Family(
        children, guardian, emergencyContact
    )
    @Test
    fun `assigns a uuid on initialization`() {
        assert(family.id is UUID)
    }

    @Test
    fun `generates empty payment history on initialization`() {
        assert(family.paymentHistory is MutableList)
        assert(family.paymentHistory.size == 0)
    }

    @Test
    fun `balance is calculated when updating payment history`() {
        family.addFee(10, LocalDate.parse("2021-11-26"))
        assertEquals(family.balance, -10)
        family.addFee(10, LocalDate.parse("2021-11-26"))
        assertEquals(family.balance, -20)
        family.addPayment(20, LocalDate.parse("2021-11-26"))
        assertEquals(family.balance, 0)
        family.addPayment(20, LocalDate.parse("2021-11-26"))
        assertEquals(family.balance, 20)
    }

    @Test
    fun `payment balance is automatically sorted chronologically`() {
        val oldestFeeDate = LocalDate.parse("2020-11-26")
        val olderFeeDate = LocalDate.parse("2021-10-26")
        val middleFeeDate = LocalDate.parse("2021-11-24")
        val laterFeeDate = LocalDate.parse("2021-11-25")
        val latestFeeDate = LocalDate.parse("2021-11-26")
        family.addFee(1, latestFeeDate)
        family.addFee(2, middleFeeDate)
        family.addFee(3, laterFeeDate)
        family.addFee(4, olderFeeDate)
        family.addFee(5, oldestFeeDate)

        assertEquals(family.paymentHistory[0].date, oldestFeeDate)
        assertEquals(family.paymentHistory[1].date, olderFeeDate)
        assertEquals(family.paymentHistory[2].date, middleFeeDate)
        assertEquals(family.paymentHistory[3].date, laterFeeDate)
        assertEquals(family.paymentHistory[4].date, latestFeeDate)
    }
}