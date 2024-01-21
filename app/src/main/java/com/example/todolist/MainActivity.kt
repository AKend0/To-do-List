package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {

    //seccion private lateinit
    private lateinit var etUser: AppCompatEditText
    private lateinit var etPassword: AppCompatEditText
    private lateinit var btnLogin: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etUser=findViewById(R.id.etUser)
        etPassword=findViewById(R.id.etPassword)
        btnLogin=findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener(View.OnClickListener {
            val user = etUser.text.toString()
            val password = etPassword.text.toString()

            if (user.isNotEmpty() && password.isNotEmpty()) {
                //signIn(user, password)
                Toast.makeText(this, "Inicio correcto", Toast.LENGTH_SHORT).show()
                Toast.makeText(this,"bienvenido", Toast.LENGTH_SHORT).show()
            } else {
                 if (user.isEmpty()) {
                     etUser.error = "Este campo no puede estar vacío"
                     etUser.requestFocus()
                } else {
                     etUser.error = null
                }

                if (password.isEmpty()) {
                    etPassword.error = "Este campo no puede estar vacío"
                    etPassword.requestFocus()
                } else {
                    etPassword.error = null
                }
            }


      })
    }
}