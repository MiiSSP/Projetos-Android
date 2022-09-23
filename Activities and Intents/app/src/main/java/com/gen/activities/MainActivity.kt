package com.gen.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Fazendo botão ter a ação de sair da primeira activity e ir para a segunda
        val buttonNext = findViewById<Button>(R.id.buttonNext)
        val intentSecond = Intent(this,SecondActivity::class.java)

        buttonNext.setOnClickListener{
            startActivity(intentSecond)
        }
    }
}