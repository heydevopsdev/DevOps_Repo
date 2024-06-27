package com.example.housemartapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.housemartapplication.auth.ParentAuthActivity

class Splash_Activity : AppCompatActivity() {
    private val SPLASH_DELAY: Long = 3000 // 3 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash) // Replace with your layout file
        HelperClass.context =  this

        // Handler to start the MainActivity after the delay
        Handler().postDelayed({
            val intent = Intent(
                this,
                OnBoardingActivity::class.java
            ) // Replace MainActivity with your desired activity
            startActivity(intent)
            finish() // Finish the splash activity so it cannot be returned to
        }, SPLASH_DELAY)
    }
}