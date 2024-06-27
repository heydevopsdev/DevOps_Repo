package com.example.housemartapplication.auth.vendorauth

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.housemartapplication.R
import com.google.android.material.textfield.TextInputEditText

class VendorSignUpActivity : AppCompatActivity() {
    lateinit var finalSignupAsVendorButton: Button

    //    lateinit var mobileNumberVendorEditText: EditText
    lateinit var nextBtnSignupAsVendor1: Button
    lateinit var gstinEditText: EditText
    lateinit var gstNoTextInputEt: TextInputEditText
    lateinit var mobNumVendorSignUpTextInputEt: TextInputEditText

    lateinit var nameTextInputEt: TextInputEditText
    lateinit var shopNameTextInputEt: TextInputEditText

    companion object {
        public var number: String = ""
        public var name: String = ""
        public var shopName: String = ""
        public var gstNo: String = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_vendor_sign_up)
//        mobileNumberVendorEditText = findViewById(R.id.mobileNumberVendorEditText)
        mobNumVendorSignUpTextInputEt = findViewById(R.id.mobNumVendorSignUpTextInputEt)
        nextBtnSignupAsVendor1 = findViewById(R.id.nextBtnSignupAsVendor1)
//        gstinEditText = findViewById(R.id.gstinEditText)
        gstNoTextInputEt = findViewById(R.id.gstNoTextInputEt)

        nameTextInputEt = findViewById(R.id.nameTextInputEt)
        shopNameTextInputEt = findViewById(R.id.shopNameTextInputEt)
        gstNoTextInputEt = findViewById(R.id.gstNoTextInputEt)


        nextBtnSignupAsVendor1.setOnClickListener {
            number = "+91" + mobNumVendorSignUpTextInputEt.text.toString()
            name = nameTextInputEt.text.toString()
            shopName = shopNameTextInputEt.text.toString()
            gstNo = gstNoTextInputEt.text.toString()
            
            var intent = Intent(this, VendorSignUpActivity2::class.java)
//            intent.putExtra("MOBILE_NUMBER_SIGN_UP", number)
            startActivity(intent)
        }


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        finalSignupAsVendorButton = findViewById<Button>(R.id.nextBtnSignupAsVendor1)
    }


}