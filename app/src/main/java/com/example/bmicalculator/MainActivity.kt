package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener {
            calculateBmi()
        }

        binding.clearButton.setOnClickListener {
            clearInputs()
        }
    }

    private fun calculateBmi() {

    }

    private fun clearInputs() {
        binding.ageInputEditText.setText("")
        binding.maleGenderRadioButton.performClick()
        binding.heightInputEditText.setText("")
        binding.weightInputEditText.setText("")
        binding.ageInputEditText.requestFocus()
    }
}