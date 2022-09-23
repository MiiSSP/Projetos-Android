package com.gen.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val buttonBack = findViewById<Button>(R.id.buttonBack)
        buttonBack.setOnClickListener { finish() }
    }
}