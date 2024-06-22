package com.example.housemartapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.housemartapplication.auth.ParentAuthActivity
import com.google.android.material.button.MaterialButton

class OnBoardingActivity : AppCompatActivity() {
    lateinit var mbStart : MaterialButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_on_boarding2)
        mbStart = findViewById(R.id.mbStart)

        mbStart.setOnClickListener {
            var intent  = Intent(this , ParentAuthActivity::class.java)
            startActivity(intent)
        }


    }
}