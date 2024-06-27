package com.example.housemartapplication.auth.vendorauth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.housemartapplication.R
import com.example.housemartapplication.auth.userauth.SignUpOtpActivity
import com.google.android.material.textfield.TextInputEditText

class VendorSignUpActivity2 : AppCompatActivity() {
    lateinit var finalSignupAsVendorButton: Button
    lateinit var shopAddressTextInputEt: TextInputEditText
    lateinit var shopLandmarkTextInputEt: TextInputEditText
    lateinit var pinCodeTextInputEt: TextInputEditText
    lateinit var cityNameTextInputEt: TextInputEditText
    lateinit var stateNameTextInputEt: TextInputEditText

    companion object {
        public var shopAddress: String = ""
        public var shopLandmark: String = ""
        public var pinCode: String = ""
        public var city: String = ""
        public var state: String = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vendor_sign_up2)

        finalSignupAsVendorButton = findViewById(R.id.finalSignupAsVendorButton)
        shopAddressTextInputEt = findViewById(R.id.shopAddressTextInputEt)
        shopLandmarkTextInputEt = findViewById(R.id.shopLandmarkTextInputEt)
        pinCodeTextInputEt = findViewById(R.id.pinCodeTextInputEt)
        cityNameTextInputEt = findViewById(R.id.cityNameTextInputEt)
        stateNameTextInputEt = findViewById(R.id.stateNameTextInputEt)




        finalSignupAsVendorButton.setOnClickListener {

//            var sendOtp = SendOtp(this,UserSignUpActivity.number)
            shopLandmark = shopLandmarkTextInputEt.text.toString()
            shopAddress = shopAddressTextInputEt.text.toString()
            pinCode = pinCodeTextInputEt.text.toString()
            city = cityNameTextInputEt.text.toString()
            state = stateNameTextInputEt.text.toString()
            val intent2 = Intent(this, SignUpOtpActivity::class.java)
            intent2.putExtra("MOBILE_NUMBER_SIGN_UP", VendorSignUpActivity.number)
            startActivity(intent2)

        }


    }
}