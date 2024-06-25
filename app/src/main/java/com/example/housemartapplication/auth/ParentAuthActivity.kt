package com.example.housemartapplication.auth

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.housemartapplication.R
import com.example.housemartapplication.auth.userauth.UserSignUpActivity
import org.json.JSONObject
import java.util.HashMap

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
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        parentSignUpBtn = findViewById(R.id.parentSignUpBtn)

        parentSignUpBtn.setOnClickListener {
            var bottomSheetFragment: BottomSheetFragment = BottomSheetFragment()
            bottomSheetFragment.show(supportFragmentManager, "BottomSheetFragment")
        }
    }

}