package com.example.bottlegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.RotateAnimation
import android.widget.ImageView
import java.util.concurrent.ThreadLocalRandom


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // hiding the activity header
        supportActionBar?.hide();

        // taking the bottle and last direction
        val bottle = findViewById<ImageView>(R.id.ivBottle)
        var lastDirection = 0

        // onclick event
        bottle.setOnClickListener{
            // new direction with random number
            val newDirection  = ThreadLocalRandom.current().nextInt(1800)

            // taking the X and y position of bottle
            val orientationX = bottle.width / 2
            val orientationY = bottle.height / 2

            // spin animation configs
            val spin  = RotateAnimation(lastDirection.toFloat(),newDirection.toFloat(),orientationX.toFloat(), orientationY.toFloat())
            spin.duration = 1800
            spin.fillAfter = true

            // setting the last direction with the current direction
            lastDirection = newDirection

            // starting the animation
            bottle.startAnimation(spin)
        }
    }
}