package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.diceroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val rollButton:Button = binding.button
        binding.button.setOnClickListener { rollDice() }
        rollDice()
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRollOne = dice.rollDiceOne()
        val diceRollTwo = dice.rollDiceTwo()
        val diceImage:ImageView = binding.dice
        val drawableResource = when (diceRollOne) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRollOne.toString()

        val diceImage2:ImageView = binding.dice2
        val drawableResource2 = when (diceRollTwo) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage2.setImageResource(drawableResource2)
        diceImage2.contentDescription = diceRollTwo.toString()
    }
}

class Dice(private val numSides:Int) {
    fun rollDiceOne():Int {
        return (1..numSides).random()
    }
    fun rollDiceTwo():Int {
        return (1..numSides).random()
    }
}