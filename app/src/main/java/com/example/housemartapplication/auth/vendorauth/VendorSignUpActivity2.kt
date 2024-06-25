package com.example.housemartapplication.auth.vendorauth

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.housemartapplication.R
import com.example.housemartapplication.RestApi.SendOtp
import com.example.housemartapplication.auth.userauth.SignUpOtpActivity
import com.example.housemartapplication.auth.userauth.UserSignUpActivity

class VendorSignUpActivity2 : AppCompatActivity() {
    lateinit var finalSignupAsVendorButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vendor_sign_up2)

        finalSignupAsVendorButton = findViewById(R.id.finalSignupAsVendorButton)
        finalSignupAsVendorButton.setOnClickListener {

            var sendOtp = SendOtp(this,UserSignUpActivity.number)
        }



    }
}