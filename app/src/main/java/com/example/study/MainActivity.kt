package com.example.study

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random
import android.view.Gravity
import kotlin.properties.Delegates


private const val PASSING_COUNT = "RANDOM_COUNT"
private const val COUNT_KEY = "count_key"
private const val DAMN1_KEY = "damn1_key"
private const val DAMN2_KEY = "damn2_key"
private const val DAMN3_KEY = "damn3_key"
private const val DAMN_SIZE1_KEY = "DAMN_SIZE1_KEY"
private const val DAMN_SIZE2_KEY = "DAMN_SIZE2_KEY"
private const val DAMN_SIZE3_KEY = "DAMN_SIZE3_KEY"

private const val MyLog = "MyLog"

class MainActivity : AppCompatActivity() {

    private lateinit var hellButton: Button
    private lateinit var leftButton: Button
    private lateinit var rightButton:Button
    private lateinit var pressDiceBtn:TextView

    private lateinit var damnTextView1: TextView
    private lateinit var damnTextView2: TextView
    private lateinit var damnTextView3: TextView
    private lateinit var counter: TextView
    private lateinit var countString: String
    private var t3 by Delegates.notNull<Float>()
    private var t1 by Delegates.notNull<Float>()
    private var t2 by Delegates.notNull<Float>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rightBtnIntent = Intent(this, rightButtonActivity::class.java)
        val pressDiceBtnIntet = Intent(this,pressDiceBtnActivity::class.java)
        hellButton = findViewById(R.id.hell_button)
        leftButton = findViewById(R.id.left_button)
        rightButton = findViewById(R.id.right_button)
        pressDiceBtn = findViewById(R.id.bye_text)
        counter = findViewById(R.id.count)
        damnTextView1 = findViewById(R.id.damn_text_1)
        damnTextView2 = findViewById(R.id.damn_text_2)
        damnTextView3 = findViewById(R.id.damn_text_3)
        t3 = 0F
        t1 = 0F
        t2 = 0F

        if (savedInstanceState != null) {
            counter.text = savedInstanceState.getString(COUNT_KEY)
            damnTextView1.text = savedInstanceState.getString(DAMN1_KEY)
            damnTextView2.text = savedInstanceState.getString(DAMN2_KEY)
            damnTextView3.text = savedInstanceState.getString(DAMN3_KEY)
            damnTextView1.textSize = savedInstanceState.getString(DAMN_SIZE1_KEY)?.toFloat()!!
            damnTextView2.textSize = savedInstanceState.getString(DAMN_SIZE2_KEY)?.toFloat()!!
            damnTextView3.textSize = savedInstanceState.getString(DAMN_SIZE3_KEY)?.toFloat()!!
        }


        countString = counter.text.toString()
        if (Integer.parseInt(countString) ==0) {
            counter.textSize = 0F
            damnTextView1.textSize = 55F
        }


        hellButton.setOnClickListener { randomize() }
        leftButton.setOnClickListener{ toastMe() }

        // start components Activity
        rightButton.setOnClickListener{
            rightBtnIntent.putExtra(PASSING_COUNT, randomValue())
            startActivity(rightBtnIntent)
        }
        pressDiceBtn.setOnClickListener{
            startActivity(pressDiceBtnIntet)
        }


        Log.d(MyLog, "onCreate\n" + damnTextView1.textSize.toString() + " " + t1 + "\n" + damnTextView2.textSize.toString() + " " + t2 + "\n" + damnTextView3.textSize.toString() + " " + t3 )


    }

    private fun randomValue(): Float {
        val i = Random.nextFloat()
        return if ( i < 0.1) randomValue() else (i * 100/1.18).toFloat()
    }

    private fun countMe() {
        countString = counter.text.toString()
        var count:Int = Integer.parseInt(countString)
        counter.textSize = 30F
        count ++
        counter.text = count.toString()
    }

//    private fun fontSizeConvert() {
//        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,)
//    }
    private fun randomize(){
        damnTextView1.text = "Damn "
        damnTextView2.text = "you"
        damnTextView3.text = " ALL!"

         t1 =  randomValue()
         t2 =  randomValue()
         t3 =  randomValue()
        if ((t1 + t2 + t3) < 190) {

            damnTextView1.textSize = t1
            damnTextView2.textSize = t2
            damnTextView3.textSize = t3


            damnTextView1.text = damnTextView1.text.toString()
            damnTextView2.text = damnTextView2.text.toString()
            damnTextView3.text = damnTextView3.text.toString()
        } else {randomize()}

        countMe()
    }

    private fun toastMe(){
        val myToast = Toast.makeText(this,"Oooooouuuuch it hurts!!!", Toast.LENGTH_LONG)
        myToast.setGravity(Gravity.TOP, Gravity.CENTER_HORIZONTAL, 1200)
        myToast.show()
        counter.textSize = 0F
        counter.text = "0"
        damnTextView1.text = "Oh nooo!!! "
        damnTextView2.text = ""
        damnTextView3.text = ""
        damnTextView1.textSize = 55F
    }

    override fun onSaveInstanceState(outState: Bundle) {
            super.onSaveInstanceState(outState)
        outState.apply {
            putString(COUNT_KEY,counter.text.toString())
            putString(DAMN1_KEY,damnTextView1.text.toString())
            putString(DAMN2_KEY,damnTextView2.text.toString())
            putString(DAMN3_KEY,damnTextView3.text.toString())
            putString(DAMN_SIZE1_KEY,damnTextView1.textSize.toString())
            putString(DAMN_SIZE2_KEY,damnTextView2.textSize.toString())
            putString(DAMN_SIZE3_KEY,damnTextView3.textSize.toString())

        }
    }


    override fun onStart() {
        super.onStart()
        Log.d(MyLog, "onStart\n" + damnTextView1.textSize.toString() + " " + t1 + "\n" + damnTextView2.textSize.toString() + " " + t2 + "\n" + damnTextView3.textSize.toString() + " " + t3 )
    }

    override fun onResume() {
        super.onResume()
        Log.d(MyLog, "onResume\n" + damnTextView1.textSize.toString() + " " + t1 + "\n" + damnTextView2.textSize.toString() + " " + t2 + "\n" + damnTextView3.textSize.toString() + " " + t3 )
    }

    override fun onPause() {
        super.onPause()
        Log.d(MyLog,"onPause\n" + damnTextView1.textSize.toString() + " " + t1 + "\n" + damnTextView2.textSize.toString() + " " + t2 + "\n" + damnTextView3.textSize.toString() + " " + t3 )

    }

    override fun onStop() {
        super.onStop()
        Log.d(MyLog,"onStop\n" + damnTextView1.textSize.toString() + " " + t1 + "\n" + damnTextView2.textSize.toString() + " " + t2 + "\n" + damnTextView3.textSize.toString() + " " + t3 )

    }

    override fun onRestart() {
        super.onRestart()
        Log.d(MyLog,"onRestart\n" + damnTextView1.textSize.toString() + " " + t1 + "\n" + damnTextView2.textSize.toString() + " " + t2 + "\n" + damnTextView3.textSize.toString() + " " + t3 )

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(MyLog,"onDestroy\n" + damnTextView1.textSize.toString() + " " + t1 + "\n" + damnTextView2.textSize.toString() + " " + t2 + "\n" + damnTextView3.textSize.toString() + " " + t3 )

    }




}
