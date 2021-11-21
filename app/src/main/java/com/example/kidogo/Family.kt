package com.example.kidogo

import java.util.*
import java.util.UUID.randomUUID

open class Transaction(
    val amount: Int,
    val date: Date
) {
    val id = randomUUID()
}

class Payment(
    amount: Int,
    date: Date
): Transaction(amount, date)

class Fee(
    amount: Int,
    date: Date
): Transaction(amount, date)


class Family(
    val children: List<Child>,
    val guardian: Guardian,
    val emergencyContact: EmergencyContact
) {
    val id = randomUUID()
    var balance = 0
    private var paymentHistory= mutableListOf<Transaction>()
    val rate = object {
        var amount: Int = 0
        var frequencey = "daily"
    }

    fun addPayment(amount: Int, date: Date) {
        addTransaction(Payment(amount, date))
    }

    fun addFee(amount: Int, date: Date) {
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
}