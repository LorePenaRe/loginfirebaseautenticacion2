package com.example.loginfirebaseautenticacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var authStateListener: FirebaseAuth.AuthStateListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnIngresar : Button = findViewById(R.id.btnIngresar)
        val txtemail : TextView = findViewById(R.id.editEmailNuevo)
        val txtpass : TextView = findViewById(R.id.editPassword)
        firebaseAuth= Firebase.auth
        btnIngresar.setOnClickListener()
        {
           signIn(txtemail.text.toString(),txtpass.toString())
        }
    }


    private fun signIn(email: String, password:String)
    {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener (this) {task ->
                if (task.isSuccessful){
                    val user = firebaseAuth.currentUser
                    Toast.makeText(baseContext,"Autenticacion Exitosa", Toast.LENGTH_SHORT).show()
                    //aqui vamos a ir a la segunda activity
                    val i = Intent(this,MainActivity2::class.java)
                    startActivity(i)
                }
                else
                    Toast.makeText(baseContext,"Error de Email y/o Contraseña", Toast.LENGTH_SHORT).show();
                    {
                }

            }

    }

}