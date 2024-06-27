package com.example.housemartapplication.auth.userauth

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.widget.doOnTextChanged
import com.example.housemartapplication.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class UserSignUpActivity : AppCompatActivity() {
    companion object {
        //        private const val TAG = "<<<>>>"
//        public const val TWILIO_ACCOUNT_SID = "ACa0bcf328516854b983ffe64f35ea1b6f"
//        public const val TWILIO_AUTH_TOKEN = "2ac0a57d62cde44464356dd7ff983452"
//        public var serviceSid: String = ""
        public var number: String = ""


    }


    private lateinit var mobileNumberEditText: EditText
    private lateinit var sendOTPButton: AppCompatButton
    lateinit var mobileNumberTextInputEditText: TextInputEditText
    lateinit var textInputLayout: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_sign_up)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

//        mobileNumberEditText = findViewById<EditText>(R.id.mobileNumberEditText)
        mobileNumberTextInputEditText =
            findViewById<TextInputEditText>(R.id.mobNumUserSignUpTextInputEt)
        sendOTPButton = findViewById<AppCompatButton>(R.id.sendOTPButton)

        textInputLayout = findViewById<TextInputLayout>(R.id.textInputLayoutUserSignUp)
        textInputLayout.setEndIconOnClickListener {
            Toast.makeText(this@UserSignUpActivity, "clicked", Toast.LENGTH_SHORT).show()
        }

        findViewById<TextInputEditText>(R.id.mobNumUserSignUpTextInputEt).doOnTextChanged { text, start, before, count ->
            if (text!!.length > 10) {
                textInputLayout.error = "No More!"
            } else if (text.length < 10) {
                textInputLayout.error = "Enter all the 10 digits of your number"
            } else {
                textInputLayout.error = null
            }
        }
        sendOTPButton.setOnClickListener {
//            var sendOtp = SendOtp(this, mobileNumberEditText.text.toString())
//            var sendOtp = SendOtp(this, mobileNumberTextInputEditText.text.toString())
//            number = "+91" + mobileNumberEditText.text.toString()
            number = "+91" + mobileNumberTextInputEditText.text.toString()
            val intent = Intent(this, SignUpOtpActivity::class.java)
            intent.putExtra("MOBILE_NUMBER_SIGN_UP", number)
            startActivity(intent)
        }
    }

    fun validateMobileNumber(): Boolean {
        val mobileNumber = mobileNumberEditText.text.toString()
        // Check If Email Is Empty:
        if (mobileNumber.isEmpty()) {
            mobileNumberEditText.error = "Number can't be empty!"
            return false
        } else if (mobileNumber.length < 10) {
            mobileNumberEditText.error = "Enter 10 digits!"
            return false
        } else {
            mobileNumberEditText.error = null
            return true
        } // Check If mobile number Is Empty.
    }


}