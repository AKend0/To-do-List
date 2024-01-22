package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.todolist.menu_principal.menuPrincipal
import com.example.todolist.register.signupActivity
import com.google.android.material.textfield.TextInputLayout

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

            // Finaliza la actividad actual para evitar que al presionar "Back" se retorne
            finish()
        }


    }

    private fun login() {
        val user = etUser.text.toString()
        val password = etPassword.text.toString()
        val prueba = txtPrueba.editText?.text.toString()

        when {
            user.isEmpty() -> {
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

            else -> {
                // Todas las validaciones pasaron, no hay errores
                etUser.error = null
                etPassword.error = null
                txtPrueba.isErrorEnabled = false
                //signIn(user, password)
                Toast.makeText(this, "Inicio correcto", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show()

                val intentMenuPrincipal = Intent(this, menuPrincipal::class.java)
                startActivity(intentMenuPrincipal)
                finish()
            }
        }
    }

    private fun initComponents() {
        etUser=findViewById(R.id.etUser)
        etPassword=findViewById(R.id.etPassword)
        btnLogin=findViewById(R.id.btnLogin)
        txtPrueba = findViewById(R.id.txtPrueba)
        btnSignup=findViewById(R.id.btnSignup)

    }
}