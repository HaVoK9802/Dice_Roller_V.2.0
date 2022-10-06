package com.example.dicerollerv20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        val imageViewObjectReference: ImageView = findViewById(R.id.imageView)
        imageViewObjectReference.setImageResource(R.drawable.dice_1)
        rollButton.setOnClickListener {
            val diceObj = Dice(6)
            val diceRollResult = diceObj.roll()
            val toast = Toast.makeText(this, "Your Dice Rolled $diceRollResult", Toast.LENGTH_SHORT)

            when (diceRollResult) {
                1 -> {

                    imageViewObjectReference.setImageResource(R.drawable.dice_1)
                    toast.show()
                }
                2 -> {

                    imageViewObjectReference.setImageResource(R.drawable.dice_2)
                    toast.show()
                }
                3 -> {

                    imageViewObjectReference.setImageResource(R.drawable.dice_3)
                    toast.show()
                }
                4 -> {

                    imageViewObjectReference.setImageResource(R.drawable.dice_4)
                    toast.show()
                }
                5 -> {

                    imageViewObjectReference.setImageResource(R.drawable.dice_5)
                    toast.show()
                }
                else -> {

                    imageViewObjectReference.setImageResource(R.drawable.dice_6)
                    toast.show()
                }
            }

        }

    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}