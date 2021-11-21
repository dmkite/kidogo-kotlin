package com.example.kidogo

import java.util.UUID.randomUUID

data class Guardian(
    var firstName: String,
    var surname: String,
    var phone: String,
    var governmentId: String?
) {
    val id = randomUUID()
}