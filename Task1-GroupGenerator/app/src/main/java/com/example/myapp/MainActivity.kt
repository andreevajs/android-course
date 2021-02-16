package com.example.myapp

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.children
import com.example.myapp.plants.PlantGroupGenerator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickGenerate(view: View){
        val itemsLayout = findViewById<LinearLayout>(R.id.itemsLayout)
        itemsLayout.removeAllViews()

        var min = 0
        var max = 0
        try {
            min = findViewById<EditText>(R.id.minItemsNumber).text.toString().toInt()
            max = findViewById<EditText>(R.id.maxItemsNumber).text.toString().toInt()
        } catch (e: Exception) { return }
        if (min > max || max > 5000)
            return;

        var number = 0
        for (plant in PlantGroupGenerator().generateRandom(min,max))
            itemsLayout.addView(TextView(this).apply {
                text = ("${++number}. $plant")
                textSize = 16f
            })
    }
}