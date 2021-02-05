package com.example.proyectocovid.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.proyectocovid.R


class DiagnosticoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diagnostico)
    }
    fun RegresarMenu2(view:View) {
        startActivity(Intent(this, MainActivity::class.java))
    }
    fun Comenzar(view:View) {
        startActivity(Intent(this, EnviarDiagnosticoActivity::class.java))
    }


}