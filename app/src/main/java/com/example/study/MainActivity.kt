package com.example.study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val hellButton: Button = findViewById(R.id.hell_button)

        hellButton.setOnClickListener { randomize() }
    }


    private fun randomize(){
        val randomValue = Random.nextInt(10,35)
        val randomValueAdd1 = Random.nextInt(0,55)
        val randomValueAdd2 = Random.nextInt(0,55)
        val randomValueAdd3 = Random.nextInt(0,55)


        val damnTextView1: TextView = findViewById(R.id.damn_text_1)
        val damnTextView2: TextView = findViewById(R.id.damn_text_2)
        val damnTextView3: TextView = findViewById(R.id.damn_text_3)
        damnTextView1.text = "Damn "
        damnTextView2.text = "you"
        damnTextView3.text = " ALL!"
        damnTextView1.textSize = randomValue.toFloat() + randomValueAdd1.toFloat()
        damnTextView2.textSize = randomValue.toFloat() + randomValueAdd2.toFloat()
        damnTextView3.textSize = randomValue.toFloat() + randomValueAdd3.toFloat()

    }
}