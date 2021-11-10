package com.example.study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

private const val PASSING_COUNT = "RANDOM_COUNT"


class rightButtonActivity : AppCompatActivity() {

    lateinit var midGhostBtn: Button
    lateinit var leftGhostBtn: Button
    lateinit var rightGhostBtn: Button
    lateinit var pumpkinBtn: Button
    lateinit var numberView:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_right_button)

        numberView = findViewById(R.id.textView)
        midGhostBtn = findViewById(R.id.midGhostBtn)
        leftGhostBtn = findViewById(R.id.leftGhostBtn)
        rightGhostBtn = findViewById(R.id.rightGhostBtn)
        pumpkinBtn = findViewById(R.id.pumpkinBtn)
        val count = intent.extras?.getFloat(PASSING_COUNT)
        if (count != null) {
            numberView.text = count.toInt().toString()
        } else {numberView.text = "0"}

        midGhostBtn.setOnClickListener{toastMidGhost()}
        leftGhostBtn.setOnClickListener{toastLeftGhost()}
        rightGhostBtn.setOnClickListener{toastRightGhost()}
        pumpkinBtn.setOnClickListener{toastMidGhost()}

    }

    private fun toastMidGhost(){
        val myToast = Toast.makeText(this,"~~ hey DUDE ~~\n get your number " +numberView.text+ "\nand f**k off", Toast.LENGTH_LONG)
        myToast.setGravity(Gravity.TOP, Gravity.CENTER_HORIZONTAL, 650)
        myToast.show()
    }

    private fun toastLeftGhost(){
        val myToast = Toast.makeText(this,"!!! BOOOOOOO !!!", Toast.LENGTH_LONG)
        myToast.setGravity(Gravity.TOP, -500, 1200)
        myToast.show()
    }

    private fun toastRightGhost(){
        val myToast = Toast.makeText(this," I'm a death dancer }=) ", Toast.LENGTH_LONG)
        myToast.setGravity(Gravity.TOP, 500, 900)
        myToast.show()
    }
}