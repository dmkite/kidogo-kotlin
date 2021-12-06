package com.example.kidogo

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ChildEntity::class], version = 1)
abstract class ChildDatabase: RoomDatabase() {
}