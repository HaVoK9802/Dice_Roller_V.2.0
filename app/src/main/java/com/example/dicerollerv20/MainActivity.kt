package com.example.dicerollerv20

import android.graphics.drawable.Drawable
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
            val drawableResource =
                when (diceRollResult) {        // this type of when statement will return a value (of any type I believe)
                    1 -> R.drawable.dice_1     // depending on the val identifier that is accepting it. Here it's determining
                    2 -> R.drawable.dice_2     // the drawable image resource.
                    3 -> R.drawable.dice_3
                    4 -> R.drawable.dice_4
                    5 -> R.drawable.dice_5
                    else -> R.drawable.dice_6
                }
            imageViewObjectReference.setImageResource(drawableResource) //this functions sets the imageView's image source.
            toast.show()
//            when (diceRollResult) {
//                1 -> {
//                    imageViewObjectReference.setImageResource(R.drawable.dice_1)
//                    toast.show()
//                }
//                2 -> {
//                    imageViewObjectReference.setImageResource(R.drawable.dice_2)
//                    toast.show()
//                }
//                3 -> {
//                    imageViewObjectReference.setImageResource(R.drawable.dice_3)
//                    toast.show()
//                }
//                4 -> {
//                    imageViewObjectReference.setImageResource(R.drawable.dice_4)
//                    toast.show()
//                }
//                5 -> {
//                    imageViewObjectReference.setImageResource(R.drawable.dice_5)
//                    toast.show()
//                }
//                else -> {
//                    imageViewObjectReference.setImageResource(R.drawable.dice_6)
//                    toast.show()
//                }
//            } // this was my logic previously, correct but not concise.

        }

    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}