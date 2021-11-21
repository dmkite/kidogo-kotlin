package com.example.kidogo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kidogo.databinding.ActivityEnrollChildBinding
import java.util.UUID.randomUUID

class EnrollChildActivity: AppCompatActivity() {
    lateinit var binding: ActivityEnrollChildBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnrollChildBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.saveButton.setOnClickListener{ saveChildData() }
    }

    private fun saveChildData() {
        val firstName = binding.firstnameInput.text.toString()
        val surname = binding.surnameInput.text.toString()
        val selectedGenderId = binding.genderInput.checkedRadioButtonId
        val gender = when (selectedGenderId) {
            R.id.gender_option_female -> "female"
            R.id.gender_option_male -> "male"
            else -> "not_listed"
        }
        val year = binding.birthdayPicker.year
        val month = binding.birthdayPicker.month
        val day = binding.birthdayPicker.dayOfMonth
        val birthday = "${day}/${month}/${year}"

        val notes = binding.notesInput.text.toString()
        val child = Child(firstName, surname, gender, birthday, notes)
        
    }

    private fun createFamilyUnit() {
//        val family = Family(mutableListOf(Child))
    }
}