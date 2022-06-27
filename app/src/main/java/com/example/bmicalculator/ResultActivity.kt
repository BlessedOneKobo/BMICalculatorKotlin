package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmicalculator.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result: Double = intent.getDoubleExtra(EXTRA_RESULT, 0.0)
        binding.resultTextView.text = getString(R.string.result_text, result)
        binding.categoryTextView.text = determineCategory(result)
    }

    private fun determineCategory(result: Double): String {
        return if (result < 16.0) {
            "Severe Thinness"
        } else if (result >= 16.0 && result < 17.5) {
            "Moderate Thinness"
        } else if (result >= 17.0 && result < 18.5) {
            "Mild Thinness"
        } else if (result >= 18.5 && result < 25.0) {
            "Normal"
        } else if (result >= 25.0 && result < 30.0) {
            "Overweight"
        } else if (result >= 30.0 && result < 35.0) {
            "Obese Class I"
        } else if (result >= 35.0 && result < 40.0) {
            "Obese Class II"
        } else {
            "Obese Class III"
        }
    }
}
