package com.example.study

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import kotlin.random.Random

class DiceGame : Fragment() {

    private lateinit var diceImg: ImageView
    private var randomVal = 1
    private lateinit var letsRoll: Animation


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.dice_game, container, false)
        diceImg = view.findViewById(R.id.dice_image)
        letsRoll = AnimationUtils.loadAnimation(getContext(), R.anim.dice_roll)
        if (savedInstanceState != null) {
            diceRandomize(savedInstanceState.getInt("dice"))
        }

        diceImg.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fragment_container,DiceGame())
                ?.addToBackStack(null)
                ?.commit()
        }
        roll()
        randomVal = Random.nextInt(1, 7)
        diceRandomize(randomVal)

        return view
    }

private fun roll(){
    diceImg.animation = letsRoll
}
    private fun diceRandomize(randomVal: Int) {
       diceImg.setImageResource(
            when (randomVal) {
                1 -> R.drawable.dice1
                2 -> R.drawable.dice2
                3 -> R.drawable.dice3
                4 -> R.drawable.dice4
                5 -> R.drawable.dice5
                6 -> R.drawable.dice6
                else -> R.drawable.dice1
            }
        )
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("dice",randomVal)
        super.onSaveInstanceState(outState)
    }

}