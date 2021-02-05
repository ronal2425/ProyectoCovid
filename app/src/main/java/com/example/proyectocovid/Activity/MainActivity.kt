package com.example.proyectocovid.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.proyectocovid.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }
    fun Info(view:View) {
        startActivity(Intent(this, InformacionActivity::class.java))
    }
    fun Comunicar(view:View) {
        startActivity(Intent(this, DiagnosticoActivity::class.java))
    }
    fun Bluetooth(view:View) {
        startActivity(Intent(this, Bluetooth()::class.java))
    }

}