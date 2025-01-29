package com.example.arxiv

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)
    }

    // Método con las funcionalidad de los botones.
    override fun onClick(v: View?) {
        // Dependiendo de qué botón se pulse, tendrá una funcionalida u otra.
        when (v?.id) {
            // Botón para dirigir al usuario a la pantalla de los créditos.
            R.id.creditActivityButton -> {
                // Guardar el usuario introducido en la caja de texto.
                val username = findViewById<EditText>(R.id.usernameEditText).text.toString()

                // Verificar si no el usuario está vacío.
                if (username.isNotEmpty()) {
                    // Crear el intent para cambiar de pantalla.
                    val intent = Intent(this, CreditActivity::class.java).apply {
                        // Añadir el extra del usuario para usarlo en los créditos.
                        putExtra("username", username)
                    }

                    // Empezar la actividad.
                    startActivity(intent)
                } else {
                    // Mostrar al usuario un aviso de que el usuario no puede estar vacío.
                    Toast.makeText(
                        applicationContext,
                        "El usuario no puede estar vacío",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            // Botón para el contacto.
            R.id.contactButton -> {
                // Crear el intent.
                val intent = Intent(Intent.ACTION_VIEW)
                // Introducir la URI con el asunto 'Consulta de la app arXiv' a mi email (vpop930@g.educaand.es).
                val data = Uri.parse("mailto:?subject='Consulta de la app arXiv'&to=vpop930@g.educaand.es")
                // Introducir la URI al intent.
                intent.setData(data)

                // Empezar la actividad.
                startActivity(intent)
            }
        }
    }
}