package com.example.proyectocovid.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import com.example.proyectocovid.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*


class EnviarDiagnosticoActivity : AppCompatActivity() {


    private lateinit var database:FirebaseDatabase
    private lateinit var reference: DatabaseReference

    lateinit var txtCodigo:EditText
    lateinit var calendarView:EditText
    lateinit var Continuar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enviar_diagnostico)


    }


    fun RegresarDiagnostico(view:View) {
        startActivity(Intent(this, DiagnosticoActivity::class.java))
    }

}