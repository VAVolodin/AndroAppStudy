package com.example.study

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

private const val KEY_PASS = "KEY_PASS"

class GameBoard : Fragment(), Datatransfer {

    enum class Turn { O, X }

    private var firstPlayer = Turn.X
    private var secondPlayer= Turn.O

    private var scoreX = 0
    private var scoreO = 0

    private var boardList = mutableListOf<Button>()

    lateinit var firstPlayerName: String
    lateinit var secondPlayerName: String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_game_board, container, false)
        val set = arguments?.getStringArray(KEY_PASS)
        firstPlayerName = (set?.get(0) ?: "Spooky ghost").toString()
        secondPlayerName = (set?.get(1) ?: "Lovely ghoul").toString()
        view.findViewById<TextView>(R.id.turnView).text = firstPlayerName
         view.findViewById<TextView>(R.id.turnSymbolView).text = secondPlayerName



        boardList.add(view.findViewById<Button>(R.id.a1))
        boardList.add(view.findViewById<Button>(R.id.a2))
        boardList.add(view.findViewById<Button>(R.id.a3))
        boardList.add(view.findViewById<Button>(R.id.b1))
        boardList.add(view.findViewById<Button>(R.id.b2))
        boardList.add(view.findViewById<Button>(R.id.b3))
        boardList.add(view.findViewById<Button>(R.id.c1))
        boardList.add(view.findViewById<Button>(R.id.c2))
        boardList.add(view.findViewById<Button>(R.id.c3))

        for (item in boardList) { item.setOnClickListener{btnClick(view)}}

        return view
    }


    private fun btnClick(view: View){
        if(view !is Button)
            return
        addToBoard(view)

        if(victoryCheck(O))
        {
            scoreO++
            result("$secondPlayerName Win!")
        }
        else if(victoryCheck(X))
        {
            scoreX++
            result("$firstPlayerName Win!")
        }

        if(fullBoard())
        {
            result("It's a DRAW!!!")
        }

    }

    private fun victoryCheck(s: String): Boolean {
        //horizontal
        if(match(boardList[0],s) && match(boardList[1],s) && match(boardList[2],s))
            return true
        if(match(boardList[3],s) && match(boardList[4],s) && match(boardList[5],s))
            return true
        if(match(boardList[6],s) && match(boardList[7],s) && match(boardList[8],s))
            return true

        //vertical
        if(match(boardList[0],s) && match(boardList[2],s) && match(boardList[6],s))
            return true
        if(match(boardList[1],s) && match(boardList[4],s) && match(boardList[7],s))
            return true
        if(match(boardList[2],s) && match(boardList[5],s) && match(boardList[8],s))
            return true

        //diagonal
        if(match(boardList[0],s) && match(boardList[4],s) && match(boardList[8],s))
            return true
        if(match(boardList[2],s) && match(boardList[4],s) && match(boardList[6],s))
            return true

        return false
    }

    private fun match(button: Button, symbol : String): Boolean = button.text == symbol

    private fun result(title: String) {
        val message = "\n$firstPlayerName:  $scoreX\n\n$secondPlayerName:  $scoreO"
        context?.let {
            AlertDialog.Builder(it)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("restart")
                { _,_ ->
                    restart()
                }
                .setCancelable(false)
                .show()
        }
    }

    private fun restart()
    {
        for(button in boardList)
        {
            button.text = ""
            button.setBackgroundColor(Color.parseColor("#6201f0"))

        }

        if(firstPlayer == Turn.O)
            firstPlayer = Turn.X
        else if(firstPlayer == Turn.X)
            firstPlayer = Turn.O

        secondPlayer= firstPlayer

        turnLabel()
    }

    private fun fullBoard(): Boolean
    {
        for(button in boardList)
        {
            if(button.text == "")
                return false
        }
        return true
    }

    private fun addToBoard(button: Button)
    {
        if(button.text != "")
            return

        if(secondPlayer== Turn.O)
        {
            button.text = O
            secondPlayer= Turn.X
        }
        else if(secondPlayer== Turn.X)
        {
            button.text = X
            secondPlayer= Turn.O
        }
        button.setBackgroundColor(Color.parseColor("#873cf1"))
        turnLabel()
    }

    private fun turnLabel()
    {
        var turnText = ""
        var turnSymbol = ""
        if(secondPlayer== Turn.X){
            turnText = firstPlayerName.toString()
            turnSymbol = "X"}
        else if(secondPlayer== Turn.O) {
            turnText = secondPlayerName.toString()
            turnSymbol = "O"
        }

        view?.findViewById<Button>(R.id.turnView)?.text = turnText
        view?.findViewById<Button>(R.id.turnSymbolView)?.text = turnSymbol
    }

    companion object
    {
        const val O = "O"
        const val X = "X"
    }

    override fun passData(view: View) {
        TODO("Not yet implemented")
    }

}