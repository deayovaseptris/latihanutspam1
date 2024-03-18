package com.ifs21017.magicnumber

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RewardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reward)

        val textCongrats: TextView = findViewById(R.id.textCongrats)
        val textAttempts: TextView = findViewById(R.id.textAttempts)

        val attempts = intent.getIntExtra("attempts", 0)
        textAttempts.text = "Jumlah Tebakan: $attempts"

        val btnRestart: Button = findViewById(R.id.btnRestart)
        btnRestart.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }
}
