package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.todolist.menu_principal.menuPrincipal
import com.example.todolist.register.signupActivity
import com.google.android.material.textfield.TextInputLayout
import user.User

class MainActivity : AppCompatActivity() {

    //seccion private lateinit
    private lateinit var etUser: AppCompatEditText
    private lateinit var etPassword: AppCompatEditText
    private lateinit var btnLogin: AppCompatButton
    private lateinit var txtPrueba: TextInputLayout
    private lateinit var btnSignup: AppCompatButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //funcion donde iniciaran los componentes
        initComponents()
        // funcion donde iniciaran los listeners
        initListeners()

    }

    private fun initListeners() {
        btnLogin.setOnClickListener {

            login()

        }

        btnSignup.setOnClickListener {
            // Inicia la actividad RegisterActivity al presionar el botón de registro
            val intent = Intent(this, signupActivity::class.java)
            startActivity(intent)

        }


    }

    private fun login() {
        val mail = etUser.text.toString()
        val password = etPassword.text.toString()
        val prueba = txtPrueba.editText?.text.toString()
        val MIN_PASSWORD_LENGTH = 4

        when {
            mail.isEmpty() -> {
                etUser.error = "Este campo no puede estar vacío"
                etUser.requestFocus()
            }

            password.isEmpty() -> {
                etPassword.error = "Este campo no puede estar vacío"
                etPassword.requestFocus()
            }

            prueba.isEmpty() -> {
                txtPrueba.error = getString(R.string.error)
            }
            password.length < MIN_PASSWORD_LENGTH -> {
                etPassword.error = "La contraseña debe tener al menos $MIN_PASSWORD_LENGTH caracteres"
                etPassword.requestFocus()

            }

            else -> {
                // Todas las validaciones pasaron, no hay errores
                val usuario = User("", mail, password)

                cleanError()

                //signIn(user, password)
                Toast.makeText(this, "Inicio correcto", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show()
                Log.d("Login", usuario.toString())

                val intentMenuPrincipal = Intent(this, menuPrincipal::class.java)
                startActivity(intentMenuPrincipal)
                finish()
            }
        }
    }

    private fun cleanError() {
        etUser.error = null
        etPassword.error = null
        txtPrueba.isErrorEnabled = false
    }

    private fun initComponents() {
        etUser=findViewById(R.id.etUser)
        etPassword=findViewById(R.id.etPassword)
        btnLogin=findViewById(R.id.btnLogin)
        txtPrueba = findViewById(R.id.txtPrueba)
        btnSignup=findViewById(R.id.btnSignup)

    }
}