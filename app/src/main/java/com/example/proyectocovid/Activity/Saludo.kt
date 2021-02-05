package com.example.proyectocovid.Activity

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowInsets
import android.view.WindowManager
import androidx.core.os.bundleOf
import com.example.proyectocovid.R
import com.google.firebase.analytics.FirebaseAnalytics

class Saludo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saludo)
        val analytics:FirebaseAnalytics= FirebaseAnalytics.getInstance(this)
        val bundle= Bundle()
        bundle.putString("message", "Integracion completa")
        analytics.logEvent("InitScreen", bundle )



        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        @Suppress("DEPRECATION")
        Handler().postDelayed({
            startActivity(Intent(this@Saludo, LoginActivity::class.java))
            finish()
        },
            2500
        )
        //val typeface: Typeface = Typeface.createFromAsset(assets, "Kids Monday.ttf")
        //tv_app_nombre.typeface = typeface


    }
}