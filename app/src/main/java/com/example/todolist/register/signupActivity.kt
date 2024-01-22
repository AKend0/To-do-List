package com.example.todolist.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.todolist.MainActivity
import com.example.todolist.R

class signupActivity : AppCompatActivity() {

    private lateinit var etUserSignUp : AppCompatEditText
    private lateinit var etPasswordSignUp : AppCompatEditText
    private lateinit var etConfirmPasswordSignup:AppCompatEditText
    private lateinit var btnRegister: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        initComponents()

        btnRegister.setOnClickListener{
            signUp()
        }

    }

    private fun signUp() {
        val user = etUserSignUp.text.toString()
        val password = etPasswordSignUp.text.toString()
        val confirmPassword = etConfirmPasswordSignup.text.toString()

        when{
            user.isEmpty() -> {
                etUserSignUp.error = "Este campo no puede estar vacío"
                etUserSignUp.requestFocus()
            }

            password.isEmpty() -> {
                etPasswordSignUp.error = "Este campo no puede estar vacío"
                etPasswordSignUp.requestFocus()
            }

            confirmPassword.isEmpty() -> {
                etConfirmPasswordSignup.error = "Este campo no puede estar vacío"
                etConfirmPasswordSignup.requestFocus()
            }

            password!= confirmPassword -> {
                etConfirmPasswordSignup.error = "Las contraseñas no coinciden"
                etConfirmPasswordSignup.requestFocus()
            }
            else -> {
                // Todas las validaciones pasaron, no hay errores
                etUserSignUp.error = null
                etPasswordSignUp.error = null
                etConfirmPasswordSignup.error = null
                Toast.makeText(this, "Registro correcto", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "Bienvenido ${user}", Toast.LENGTH_SHORT).show()

                val intentLogin = Intent(this, MainActivity::class.java)
                startActivity(intentLogin)
                finish()
            }
        }
    }

    private fun initComponents() {
        etUserSignUp=findViewById(R.id.etUserSignUp)
        etPasswordSignUp=findViewById(R.id.etPasswordSignup)
        etConfirmPasswordSignup=findViewById(R.id.etConfirmPasswordSignup)
        btnRegister=findViewById(R.id.btnRegister)
    }

}