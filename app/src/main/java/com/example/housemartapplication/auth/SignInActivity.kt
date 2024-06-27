package com.example.housemartapplication.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.housemartapplication.R
import com.google.android.material.textfield.TextInputEditText

class SignInActivity : AppCompatActivity() {

    lateinit var signInSendOTPButton: Button
    lateinit var mobNumUserSignInTextInputEt: TextInputEditText

    companion object {
        var mobileNumber: String = "+91"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


//        use this for sign out
//        Firebase.auth.signOut()

        mobNumUserSignInTextInputEt = findViewById(R.id.mobNumUserSignInTextInputEt)
        signInSendOTPButton = findViewById(R.id.signInSendOTPButton)
        signInSendOTPButton.setOnClickListener {

            //firebase mobile auth
            mobileNumber += mobNumUserSignInTextInputEt.text.toString()
            Log.d("mobileNumber", mobileNumber)
            startActivity(Intent(this, SignInOtpActivity::class.java))
        }
    }
}