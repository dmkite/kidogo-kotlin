package com.example.kidogo

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID.randomUUID

@Entity
data class ChildEntity(
    @PrimaryKey private val id: String,
    private var firstName: String,
    private var surname: String,
    private var gender: String,
    private var birthday: String,
    private var notes: String
)

data class Child(
    var firstName: String,
    var surname: String,
    var gender: String,
    var birthday: String,
    var notes: String
) {
    val id = randomUUID()
}