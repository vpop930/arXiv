package com.example.arxiv.main

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.arxiv.R

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

        // Crear la animación con credits.xml.
        val animation: Animation = AnimationUtils.loadAnimation(applicationContext, R.anim.credits)
        // Buscar el TextView con el texto de la descripción de la aplicación.
        val textView: TextView = findViewById(R.id.creditsView)

        // Guardar el texto ya introducido por defecto.
        val before: String = textView.text.toString()
        // Guardar el usuario recibido del intent.
        val intentValue = intent.getStringExtra("username")

        // Hacer que aparezca el usuario antes de la descripción de la app.
        textView.apply {
            text = intentValue + ", " + before
        }

        // Empezar la animación.
        textView.startAnimation(animation)
    }
}