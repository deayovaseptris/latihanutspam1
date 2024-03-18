package com.ifs21017.magicnumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var randomNumber: Int = 0
    private var attempts: Int = 0
    private lateinit var textGuessHint: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        randomNumber = Random.nextInt(1, 101)

        val textHint: TextView = findViewById(R.id.textHint)
        val textAttempts: TextView = findViewById(R.id.textAttempts)
        val editGuess: EditText = findViewById(R.id.editGuess)
        val btnGuess: Button = findViewById(R.id.btnGuess)

        textGuessHint = findViewById(R.id.textGuessHint)
        textHint.text = "Magic Number"
        textAttempts.text = "Jumlah tebakan: $attempts"

        btnGuess.setOnClickListener {
            val guess = editGuess.text.toString().toIntOrNull()
            guess?.let { checkGuess(it, textHint, textAttempts, textGuessHint) }
        }
    }

    private fun checkGuess(guess: Int, textHint: TextView, textAttempts: TextView, textGuessHint: TextView) {
        attempts++

        when {
            guess < randomNumber -> {
                textGuessHint.text = "Tebak dengan angka yang lebih besar"
            }
            guess > randomNumber -> {
                textGuessHint.text = "Tebak dengan angka yang lebih kecil"
            }
            else -> {
                val intent = Intent(this, RewardActivity::class.java)
                intent.putExtra("attempts", attempts)
                startActivity(intent)
                return
            }
        }
        textAttempts.text = "Jumlah tebakan: $attempts"
    }
}
