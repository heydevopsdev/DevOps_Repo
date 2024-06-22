package com.example.housemartapplication.auth.userauth

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.housemartapplication.R
import com.example.housemartapplication.RestApi.ResendOtp
import com.example.housemartapplication.RestApi.VerifyOtp
import com.google.android.material.textfield.TextInputEditText

class SignUpOtpActivity : AppCompatActivity() {
    private lateinit var mobileFetchTextView: TextView
    private lateinit var verifyOTPButton: Button
    private lateinit var otpEditText: EditText
    private lateinit var txtResendTime: TextView
    private lateinit var resendOtpTextView: TextView
    private lateinit var txtResendText: TextView
    private lateinit var llOtpSection: LinearLayout
    private lateinit var otpTextInputEt: TextInputEditText
    val TAG = "<<<>>>"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_sign_up_otp)

        mobileFetchTextView = findViewById(R.id.mobileFetchTextView)
        txtResendText = findViewById(R.id.txtResendText)
//        otpEditText = findViewById(R.id.otpEditText)
        verifyOTPButton = findViewById(R.id.verifyOTPButton)
        txtResendTime = findViewById(R.id.txtResendTime)
        resendOtpTextView = findViewById(R.id.resendOtpTextView)
        llOtpSection = findViewById(R.id.llOtpSection)
        otpTextInputEt = findViewById(R.id.otpTextInputEt)

        mobileFetchTextView.setText(UserSignUpActivity.number)

        verifyOTPButton.setOnClickListener {
//            Log.d(".....<<>>", otpEditText.text.toString());
            Log.d(".....<<>>", otpTextInputEt.text.toString());
            var verifyCode =
                VerifyOtp(this, UserSignUpActivity.number, otpTextInputEt.text.toString())
        }
        resendOtpTextView.setOnClickListener {
            var sendOtp = ResendOtp(this)
        }
        countDown()
    }

    private fun countDown() {
        val countDownTimer = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // Update the TextView with the remaining time
                txtResendTime.text = (millisUntilFinished / 1000).toString() + " second"
            }

            override fun onFinish() {
                // Handle the timer finishing (optional)
                txtResendTime.text = "0"
                llOtpSection.visibility = View.VISIBLE
                txtResendTime.visibility = View.GONE
                txtResendText.visibility = View.GONE
            }
        }

        // Start the countdown timer
        countDownTimer.start()
    }
}