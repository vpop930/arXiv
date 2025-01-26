package com.example.arxiv

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CreditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_credit)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_credit)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val animation: Animation = AnimationUtils.loadAnimation(applicationContext, R.anim.credits)
        val textView: TextView = findViewById(R.id.creditsView)
        
        val before: String = textView.text.toString()
        val intentValue = intent.getStringExtra("username")

        textView.apply {
            text = intentValue + " " + before
        }

        textView.startAnimation(animation)
    }
}