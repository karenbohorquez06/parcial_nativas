package com.example.taller_2

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PerfilActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        // Inicializar los campos
        val nombre_perfil: TextView = findViewById(R.id.nombre_perfil)
        val apellido_perfil: TextView = findViewById(R.id.apellidos_perfil)
        val correo_perfil: TextView = findViewById(R.id.correo_perfil)
        val telefono_perfil: TextView = findViewById(R.id.telefono_perfil)
        val btn_editar_perfil: Button = findViewById(R.id.btn_editar_perfil)

        // Obtener los datos del SharedPreferences
        val nombrep= sharedPreferences.getString("nombre", "")
        val apellidop = sharedPreferences.getString("apellidos", "")
        val correp = sharedPreferences.getString("correo", "")
        val telefonop = sharedPreferences.getString("telefono", "")

        // Establecer los valores en los TextViews
        nombre_perfil.text = nombrep
        apellido_perfil.text = apellidop
        correo_perfil.text = correp
        telefono_perfil.text = telefonop

        // Configurar el OnClickListener para el botón de editar
        btn_editar_perfil.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }
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