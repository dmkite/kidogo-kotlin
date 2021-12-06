package com.example.kidogo

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddChildViewModel @Inject constructor(
    private val childRepository: AddChildRepository
): ViewModel() {
    private val _firstName = MutableLiveData<String>()
    val firstName: LiveData<String> = _firstName

    fun doThing(): Int {
        val x = 1
        childRepository.testFun()
        return x
    }
}