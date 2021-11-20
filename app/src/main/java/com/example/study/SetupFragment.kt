package com.example.study

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

private const val KEY_PASS = "KEY_PASS"
private const val PLAYER1_NAME = "PLAYER1_NAME"
private const val PLAYER2_NAME = "PLAYER2_NAME"

class SetupFragment : Fragment() {

    private lateinit var firstPlayerNameText:TextView
    private lateinit var secondPlayerNameText:TextView
    private lateinit var communicator: Communicator

    private lateinit var submitBtn: Button
    private lateinit var exitBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       var view = inflater.inflate(R.layout.fragment_setup, container, false)
        firstPlayerNameText = view.findViewById(R.id.player1_nameText)
        secondPlayerNameText = view.findViewById(R.id.player2_nameText)
        submitBtn = view.findViewById(R.id.submit_button)
        exitBtn = view.findViewById(R.id.exit_button)

        communicator = requireActivity() as Communicator


        if (savedInstanceState != null){
            firstPlayerNameText.hint = savedInstanceState.getString(PLAYER1_NAME)
            secondPlayerNameText.hint = savedInstanceState.getString(PLAYER2_NAME)
        }


        submitBtn.setOnClickListener {
            val namesArray = arrayOf(
                firstPlayerNameText.text.toString(),
                secondPlayerNameText.text.toString()
            )
            communicator.passString( KEY_PASS,namesArray )

        }

        exitBtn.setOnClickListener {
            val count = activity?.supportFragmentManager?.backStackEntryCount
            for (i in 0..count!!) {
                activity?.supportFragmentManager?.popBackStack()
            }
                val intent = Intent(this.requireContext(), MainActivity::class.java)
                startActivity(intent)
                    }


        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.apply {
            putString(PLAYER1_NAME,firstPlayerNameText.text.toString())
            putString(PLAYER2_NAME,secondPlayerNameText.text.toString())

        }
        super.onSaveInstanceState(outState)
    }

}