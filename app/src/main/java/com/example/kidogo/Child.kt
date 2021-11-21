package com.example.kidogo

import java.util.UUID.randomUUID

data class Child(
    var firstName: String,
    var surname: String,
    var gender: String,
    var birthday: String,
    var notes: String
) {
    val id = randomUUID()
}