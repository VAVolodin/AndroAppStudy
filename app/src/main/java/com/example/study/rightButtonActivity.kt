package com.example.study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast

private const val PASSING_COUNT = "RANDOM_COUNT"


class rightButtonActivity : AppCompatActivity() {

    lateinit var midGhostBtn: TextView
    lateinit var leftGhostBtn: TextView
    lateinit var rightGhostBtn: TextView
    lateinit var pumpkinBtn: TextView
    lateinit var numberView:TextView
    lateinit var catsBtn: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_right_button)

        numberView = findViewById(R.id.textView)
        midGhostBtn = findViewById(R.id.midGhostBtn)
        leftGhostBtn = findViewById(R.id.leftGhostBtn)
        rightGhostBtn = findViewById(R.id.rightGhostBtn)
        pumpkinBtn = findViewById(R.id.pumpkinBtn)
        catsBtn = findViewById(R.id.cats_button)

        val count = intent.extras?.getFloat(PASSING_COUNT)
        if (count != null) {
            numberView.text = count.toInt().toString()
        } else {numberView.text = "0"}

        midGhostBtn.setOnClickListener{toastMidGhost()}
        leftGhostBtn.setOnClickListener{toastLeftGhost()}
        rightGhostBtn.setOnClickListener{toastRightGhost()}
        pumpkinBtn.setOnClickListener{toastMidGhost()}
        catsBtn.setOnClickListener{ showCats() }


    }

    private fun toastMidGhost(){
        val myToast = Toast.makeText(this,"~~ hey DUDE ~~\n get your number " +numberView.text+ "\nand GET OUT !!!", Toast.LENGTH_LONG)
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

    private fun showCats() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container,CatsGallery())
            .addToBackStack(null)
            .commit()
    }

}