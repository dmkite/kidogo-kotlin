package com.example.kidogo

import javax.inject.Inject

class AddChildRepository @Inject constructor() {
    suspend fun getChild(childId: String?) = ""
    fun testFun():String {
        val x = 1
        return "hi"
    }
}