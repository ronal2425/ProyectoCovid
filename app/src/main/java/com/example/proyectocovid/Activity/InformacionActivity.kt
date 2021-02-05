package com.example.proyectocovid.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.proyectocovid.R

class InformacionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion)



    }
    fun regresarMenu(view:View) {
        startActivity(Intent(this, MainActivity::class.java))
    }
}