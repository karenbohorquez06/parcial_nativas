package com.example.taller_2

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RecuperarcActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperar_contrasena)

        val logoImageView: ImageView = findViewById(R.id.logo_recuperar_contraseña)
        val instructionTextView: TextView = findViewById(R.id.tv_instrutivo_recuperar)
        val et_correo_recuperar: EditText = findViewById(R.id.et_correo_recuperar)
        val enviar_solicitud_recuperar: Button = findViewById(R.id.enviar_solicitud_recuperar)

        enviar_solicitud_recuperar.setOnClickListener {
            val email = et_correo_recuperar.text.toString()
            if (email.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                // Aquí puedes agregar la lógica para enviar la solicitud de recuperación de contraseña
                enviarCorreoDeRecuperación(email)
            } else {
                Toast.makeText(this, "Por favor, ingresa un correo electrónico válido.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun enviarCorreoDeRecuperación(email: String) {
        // Simulación del envío de correo electrónico
        Toast.makeText(this, "Solicitud de recuperación de contraseña enviada a $email", Toast.LENGTH_LONG).show()
        // Aquí puedes agregar la lógica real para enviar el correo electrónico a través de un servidor backend
    }
    override fun onStart() {
        super.onStart()
        Log.d("SplashActivity", "onStart: Activity Splash esta en primer plano")
    }

    override fun onResume() {
        super.onResume()
        Log.d("SplashActivity", "onResume: Activity Splash esta en primer plano")
    }

    override fun onStop() {
        super.onStop()
        Log.d("SplashActivity", "onStop: Activity Splash esta en pausada")
    }

    override fun onPause() {
        super.onPause()
        Log.d("SplashActivity", "onPause: Activity Splash esta pausado")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SplashActivity", "onDestroy: Activity Splash esta destruida")
    }
}