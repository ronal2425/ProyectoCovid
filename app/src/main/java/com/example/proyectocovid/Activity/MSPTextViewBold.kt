package com.example.proyectocovid.Activity

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import java.util.jar.Attributes

class MSPTextViewBold(context: Context, attrs: AttributeSet) : AppCompatTextView(context, attrs){

    init {
        applyFont ()
    }

    private fun applyFont(){
        val typeface: Typeface=
            Typeface.createFromAsset(context.assets,"GOLDSTICK.ttf")
        setTypeface(typeface)


    }
}