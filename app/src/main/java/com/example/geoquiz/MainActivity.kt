package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.example.geoquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true))
    private var currentIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
            binding.nextButton.setOnClickListener {
                currentIndex = (currentIndex + 1) % questionBank.size
                val questionTextResId = questionBank[currentIndex].textResId
                binding.questionTextView.setText(questionTextResId)
                updateQuestion()
            }

        binding.trueButton.setOnClickListener { view: View ->
            Snackbar.make(trueButton,R.string.correct_snackbar, Snackbar.LENGTH_SHORT).show()
        }

        binding.falseButton.setOnClickListener { view: View ->
            Snackbar.make(falseButton,R.string.incorrect_snackbar, Snackbar.LENGTH_SHORT).show()
        }
        val questionTextResId = questionBank[currentIndex].textResId
        binding.questionTextView.setText(questionTextResId)
        updateQuestion()
    }
    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        binding.questionTextView.setText(questionTextResId)
    }
    }
