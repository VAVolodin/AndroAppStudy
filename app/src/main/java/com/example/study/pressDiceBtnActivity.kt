package com.example.study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val SELECTED_ITEM = "SELECTED_ITEM"

class pressDiceBtnActivity : AppCompatActivity(),Communicator {

    private lateinit var bottomnav:BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.press_dice_btn)

        bottomnav = findViewById(R.id.bottom_nav)

        bottomnav.setOnItemSelectedListener { item ->
            var fragment:Fragment? = null
            when(item.itemId){

                R.id.titactoe -> {
                    fragment = GameBoard()
                }
                R.id.setup -> {
                    fragment = SetupFragment()
                }
                R.id.dice -> {
                    fragment = DiceGame()
                }

            }
            replaceFragment(fragment !!)
            true
        }

        bottomnav.selectedItemId = savedInstanceState?.getInt(SELECTED_ITEM)?:R.id.setup


    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(SELECTED_ITEM,bottomnav.selectedItemId)
        super.onSaveInstanceState(outState)
    }

     fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container,fragment)
            .addToBackStack(null)
            .commit()
    }

    fun btnClick(view: android.view.View) {

    }

    // passing data to GameBoard fragment
    override fun passString(key: String, strArray:Array<String>) {
        val bundle = Bundle()
        bundle.putStringArray(key, strArray)

        val transaction = this.supportFragmentManager.beginTransaction()

        val gameBoard = GameBoard()
        gameBoard.arguments = bundle

        transaction
            .replace(R.id.fragment_container,gameBoard)
            .addToBackStack(null)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit()
    }


}