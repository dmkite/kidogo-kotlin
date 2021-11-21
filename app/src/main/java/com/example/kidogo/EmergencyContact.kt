package com.example.kidogo

import java.util.UUID.randomUUID

data class EmergencyContact(
    var firstName: String,
    var surname: String,
    var phone: String,
) {
    val id = randomUUID()
}