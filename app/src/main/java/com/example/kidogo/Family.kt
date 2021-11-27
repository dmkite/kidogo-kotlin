package com.example.kidogo

import java.time.LocalDate
import java.util.*
import java.util.UUID.randomUUID

open class Transaction(
    val amount: Int,
    val date: LocalDate
) {
    val id: UUID = randomUUID()
}

class Payment(
    amount: Int,
    date: LocalDate
): Transaction(amount, date)

class Fee(
    amount: Int,
    date: LocalDate
): Transaction(amount, date)


class Family(
    val children: List<Child>,
    val guardian: Guardian,
    val emergencyContact: EmergencyContact
) {
    val familyName = "TEST" // guardian.surname
    val id = randomUUID()
    var balance = 0
    var paymentHistory= mutableListOf<Transaction>()
    val rate = object {
        var amount: Int = 0
        var frequencey = "daily"
    }

    fun addPayment(amount: Int, date: LocalDate) {
        addTransaction(Payment(amount, date))
    }

    fun addFee(amount: Int, date: LocalDate) {
        addTransaction(Fee(amount, date))
    }

    private fun addTransaction(transaction: Transaction) {
        paymentHistory.add(transaction)
        paymentHistory.sortBy { it.date }
        for (transaction in paymentHistory) {
            if (transaction is Payment) {
               balance = balance + transaction.amount
            } else {
                balance = balance - transaction.amount
            }
        }
    }

    fun removeTransaction(id: UUID) {
        val trans = paymentHistory.firstOrNull{it -> it.id == id}
        trans ?: paymentHistory.remove(trans)
    }
}