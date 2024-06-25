package com.example.housemartapplication.auth.vendorauth

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.housemartapplication.R
import com.example.housemartapplication.auth.userauth.UserSignUpActivity
import com.google.android.material.textfield.TextInputEditText

class VendorSignUpActivity : AppCompatActivity() {
    lateinit var finalSignupAsVendorButton: Button

    //    lateinit var mobileNumberVendorEditText: EditText
    lateinit var nextBtnSignupAsVendor1: Button
    lateinit var gstinEditText: EditText
    lateinit var gstNoTextInputEt: TextInputEditText
    lateinit var mobNumVendorSignUpTextInputEt: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_vendor_sign_up)
//        mobileNumberVendorEditText = findViewById(R.id.mobileNumberVendorEditText)
        mobNumVendorSignUpTextInputEt = findViewById(R.id.mobNumVendorSignUpTextInputEt)
        nextBtnSignupAsVendor1 = findViewById(R.id.nextBtnSignupAsVendor1)
//        gstinEditText = findViewById(R.id.gstinEditText)
        gstNoTextInputEt = findViewById(R.id.gstNoTextInputEt)

        nextBtnSignupAsVendor1.setOnClickListener {
            UserSignUpActivity.number = mobNumVendorSignUpTextInputEt.text.toString()

            var intent = Intent(this, VendorSignUpActivity2::class.java)
            startActivity(intent)
        }


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        finalSignupAsVendorButton = findViewById<Button>(R.id.nextBtnSignupAsVendor1)
    }


}