package com.example.bmicalculator

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import com.example.bmicalculator.const.BmiConstants.MAX_AGE
import com.example.bmicalculator.const.BmiConstants.MIN_AGE
import com.example.bmicalculator.const.BmiConstants.SNACKBAR_DURATION
import com.example.bmicalculator.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

const val EXTRA_RESULT = "com.example.bmicalculator.EXTRA_RESULT"

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
        hideKeyboard()

        val age: Int? = binding.ageInputEditText.text.toString().toIntOrNull()
        if (age == null || age < MIN_AGE || age > MAX_AGE) {
            Snackbar.make(binding.root, "Age must be between $MIN_AGE and $MAX_AGE", SNACKBAR_DURATION).show()
            return
        }

        val height: Double? = binding.heightInputEditText.text.toString().toDoubleOrNull()
        if (height == null || height == 0.0) {
            Snackbar.make(binding.root, "Height is required", SNACKBAR_DURATION).show()
            return
        }

        val weight: Double? = binding.weightInputEditText.text.toString().toDoubleOrNull()
        if (weight == null || weight == 0.0) {
            Snackbar.make(binding.root, "Weight is required", SNACKBAR_DURATION).show()
            return
        }

        val heightInMeters = height / 100.0
        val bmi: Double = weight / (heightInMeters * heightInMeters)
        val intent = Intent(this, ResultActivity::class.java).apply {
            putExtra(EXTRA_RESULT, bmi)
        }
        startActivity(intent)
    }

    private fun clearInputs() {
        binding.ageInputEditText.setText("")
        binding.maleGenderRadioButton.performClick()
        binding.heightInputEditText.setText("")
        binding.weightInputEditText.setText("")
        binding.ageInputEditText.requestFocus()
    }

    private fun hideKeyboard() {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }
}