package com.example.housemartapplication.auth

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.housemartapplication.R

class ParentAuthActivity : AppCompatActivity() {
    lateinit var parentSignUpBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_parent_auth)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)


//        parentSignUpBtn = findViewById(R.id.parentSignUpBtn)

        BottomSheetFragment().show(supportFragmentManager, "BottomSheetFragment")
        BottomSheetFragment().isCancelable = false

//        parentSignUpBtn.setOnClickListener {
//            val bottomSheetFragment: BottomSheetFragment = BottomSheetFragment()
//            bottomSheetFragment.show(supportFragmentManager, "BottomSheetFragment")
//        }

//        parentSignUpBtn = findViewById(R.id.parentSignUpBtn)

    }

}