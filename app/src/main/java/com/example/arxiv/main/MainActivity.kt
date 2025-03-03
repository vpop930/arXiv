package com.example.arxiv.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.arxiv.R
import com.example.arxiv.data.User
import com.example.arxiv.data.UserDatabase
import com.example.arxiv.data.UserRepository

class MainActivity : AppCompatActivity(), View.OnClickListener {
    // Crear conexión a la base de datos.
    private var db: UserDatabase? = null
    private var repository: UserRepository? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        db = Room.databaseBuilder(this, UserDatabase::class.java, "arxiv_db").allowMainThreadQueries().build()
        repository = UserRepository(db!!.dao)

        setContentView(R.layout.activity_main)
    }

    private fun getUsername() : String {
        return findViewById<EditText>(R.id.usernameEditText).text.toString()
    }

    private fun saveUser(user: User) {
        repository?.insertUser(user)
    }

    // Método con las funcionalidad de los botones.
    override fun onClick(v: View?) {
        // Dependiendo de qué botón se pulse, tendrá una funcionalidad u otra.
        when (v?.id) {
            // Botón para dirigir al usuario a la pantalla de la lista de los artículos.
            R.id.loginActivityButton -> {
                // Guardar el usuario introducido en la caja de texto.
                val username = getUsername()

                saveUser(User(username = username))

                // Verificar si no el usuario está vacío.
                if (username.isNotEmpty()) {
                    // Crear el intent para cambiar de pantalla.
                    val intent = Intent(this, ArticleCRUD::class.java).apply {
                        // Añadir el extra del usuario para usarlo.
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