package com.example.taller_2

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class RegistroActivity : AppCompatActivity() {

    private lateinit var et_nombre_registro: EditText
    private lateinit var et_apellidos_registro: EditText
    private lateinit var et_correo_registro: EditText
    private lateinit var et_telefono_registro: EditText
    private lateinit var et_contraseña_registro: EditText
    private lateinit var et_repetir_con_registro: EditText
    private lateinit var btn_registo: Button
    private lateinit var cbx_terminos_registro: CheckBox
    private lateinit var btnVolverInicio: Button

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        Log.d("RegistroActivity", "onCreate: Registro Activity Iniciado")

        // Inicializar variable
        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        // Inicializar las variables de vistas
        et_nombre_registro = findViewById(R.id.et_nombre_registro)
        et_apellidos_registro = findViewById(R.id.et_apellidos_registro)
        et_telefono_registro = findViewById(R.id.et_telefono_registro)
        et_correo_registro = findViewById(R.id.et_correo_registro)
        et_contraseña_registro = findViewById(R.id.et_contraseña_registro)
        et_repetir_con_registro = findViewById(R.id.et_repetir_con_registro)
        btn_registo = findViewById(R.id.btn_registo)
        cbx_terminos_registro = findViewById(R.id.cbx_terminos_registro)
        btnVolverInicio = findViewById(R.id.volver_inicio)

        btn_registo.setOnClickListener {
            if (validarCampos()) {
                guardarDatosRegistro()
                // Redireccionamiento a PerfilActivity
                val intent = Intent(this, PerfilActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        btnVolverInicio.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun validarCampos(): Boolean {
        val nombre = et_nombre_registro.text.toString().trim()
        if (nombre.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese su nombre.", Toast.LENGTH_SHORT).show()
            return false
        }

        val apellidos = et_apellidos_registro.text.toString().trim()
        if (apellidos.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese sus apellidos.", Toast.LENGTH_SHORT).show()
            return false
        }

        val correo = et_correo_registro.text.toString().trim()
        if (correo.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese su correo electrónico.", Toast.LENGTH_SHORT).show()
            return false
        }

        val telefono = et_telefono_registro.text.toString().trim()
        if (telefono.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese su número de teléfono.", Toast.LENGTH_SHORT).show()
            return false
        }

        val contraseña = et_contraseña_registro.text.toString().trim()
        if (contraseña.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese una contraseña.", Toast.LENGTH_SHORT).show()
            return false
        }

        val repetirContraseña = et_repetir_con_registro.text.toString().trim()
        if (repetirContraseña.isEmpty()) {
            Toast.makeText(this, "Por favor, repita su contraseña.", Toast.LENGTH_SHORT).show()
            return false
        }

        if (contraseña != repetirContraseña) {
            Toast.makeText(this, "Las contraseñas no coinciden.", Toast.LENGTH_SHORT).show()
            return false
        }

        val terminosCondiciones = cbx_terminos_registro.isChecked
        if (!terminosCondiciones) {
            Toast.makeText(this, "Debe aceptar los términos y condiciones.", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun guardarDatosRegistro() {
        val editor = sharedPreferences.edit()
        editor.putString("nombre", et_nombre_registro.text.toString().trim())
        editor.putString("apellidos", et_apellidos_registro.text.toString().trim())
        editor.putString("correo", et_correo_registro.text.toString().trim())
        editor.putString("telefono", et_telefono_registro.text.toString().trim())
        editor.putString("contraseña", et_contraseña_registro.text.toString().trim())
        editor.apply()
        Log.d("RegistroActivity", "guardarDatosRegistro: Datos del Usuario guardados")
        Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
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