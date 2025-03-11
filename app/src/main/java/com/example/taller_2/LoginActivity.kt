package com.example.taller_2

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var etUsuario: EditText
    private lateinit var etContraseña: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginn)

        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        etUsuario = findViewById(R.id.te_usuario)
        etContraseña = findViewById(R.id.te_contraseña)
        val btnIngresar: Button = findViewById(R.id.btn_ingresar)
        val tvInstrutivoRecuperar: TextView = findViewById(R.id.tv_instrutivo_recuperar)
        val tvRegistrate: Button = findViewById(R.id.tv_registrate)

        btnIngresar.setOnClickListener {
            val usuario = etUsuario.text.toString().trim()
            val contraseña = etContraseña.text.toString().trim()

            val storedCorreo = sharedPreferences.getString("correo", "")
            val storedContraseña = sharedPreferences.getString("contraseña", "")

            if (usuario == storedCorreo && contraseña == storedContraseña) {
                val intent = Intent(this, PerfilActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Credenciales incorrectas. Por favor, inténtelo de nuevo.", Toast.LENGTH_SHORT).show()
            }
        }

        tvInstrutivoRecuperar.setOnClickListener {
            val intent = Intent(this, RecuperarcActivity::class.java)
            startActivity(intent)
        }

        tvRegistrate.setOnClickListener {
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