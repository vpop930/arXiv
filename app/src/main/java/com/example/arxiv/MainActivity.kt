package com.example.arxiv

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.test)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.creditActivityButton -> {
                val username = findViewById<EditText>(R.id.usernameEditText).text.toString()
                if (username.isNotEmpty()) {
                    val intent = Intent(this, CreditActivity::class.java).apply {
                        putExtra("username", username)
                    }

                    startActivity(intent)
                } else {
                    Toast.makeText(
                        applicationContext,
                        "El usuario no puede estar vacío",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}