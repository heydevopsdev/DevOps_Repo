package com.example.housemartapplication.auth

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.housemartapplication.MainActivity
import com.example.housemartapplication.R
import com.example.housemartapplication.auth.SignInActivity.Companion.mobileNumber
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider

class SignInOtpActivity : AppCompatActivity() {
    lateinit var txtResendTimeSignInOtp: TextView // TextView for the resend time
    lateinit var llOtpSectionSignIn: LinearLayout
    lateinit var verifyOTPButtonSignInOtp: Button
    lateinit var otpTextInputEtSignIn: TextInputEditText
    lateinit var mobileFetchTextViewSignInOtp: TextView

    val TAG = "firebaseAuth"


    val mFirebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    lateinit var verificationCode: String
    lateinit var forceResendingToken: PhoneAuthProvider.ForceResendingToken
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in_otp)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtResendTimeSignInOtp = findViewById(R.id.txtResendTextSignInOtp)
        llOtpSectionSignIn = findViewById(R.id.llOtpSectionSignIn)
        verifyOTPButtonSignInOtp = findViewById(R.id.verifyOTPButtonSignInOtp)
        otpTextInputEtSignIn = findViewById(R.id.otpTextInputEtSignIn)
        mobileFetchTextViewSignInOtp = findViewById(R.id.mobileFetchTextViewSignInOtp)
        mobileFetchTextViewSignInOtp.text = mobileNumber


        sendFirebaseOtp(mobileNumber = mobileNumber, isResend = false)

        verifyOTPButtonSignInOtp.setOnClickListener {
            // Handle the verification of the OTP
            val enteredOTP: String = otpTextInputEtSignIn.text.toString()
            var phoneAuthCredential: PhoneAuthCredential =
                PhoneAuthProvider.getCredential(verificationCode, enteredOTP)
            signIn(phoneAuthCredential)

        }

        txtResendTimeSignInOtp.setOnClickListener {
            sendFirebaseOtp(mobileNumber = mobileNumber, isResend = true)
        }

    }


    private fun countDown() {
        val countDownTimer = object : CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // Update the TextView with the remaining time
                txtResendTimeSignInOtp.text = (millisUntilFinished / 1000).toString() + " second"
            }

            override fun onFinish() {
                // Handle the timer finishing (optional)
                txtResendTimeSignInOtp.text = "0"
                llOtpSectionSignIn.visibility = View.VISIBLE
                txtResendTimeSignInOtp.visibility = View.GONE
                txtResendTimeSignInOtp.visibility = View.GONE
            }
        }

        // Start the countdown timer
        countDownTimer.start()
    }

    fun sendFirebaseOtp(mobileNumber: String, isResend: Boolean) {
        //send otp to mobile number
        countDown()
        val builder: PhoneAuthOptions.Builder =
            PhoneAuthOptions.newBuilder(mFirebaseAuth).setPhoneNumber(mobileNumber)
                .setTimeout(60L, java.util.concurrent.TimeUnit.SECONDS).setActivity(this)
                .setCallbacks(//firebase PhoneAuthOptions callbacks
                    object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                        override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                            Log.d(TAG, "onVerificationCompleted: $p0")
                            signIn(p0)

                        }

                        override fun onVerificationFailed(p0: FirebaseException) {
                            Log.d(TAG, "onVerificationFailed: $p0")
                            Toast.makeText(
                                this@SignInOtpActivity, "Verification failed", Toast.LENGTH_LONG
                            ).show()
                        }

                        override fun onCodeSent(
                            p0: String, p1: PhoneAuthProvider.ForceResendingToken
                        ) {
                            Log.d(TAG, "onCodeSent: $p0")
                            Toast.makeText(this@SignInOtpActivity, "OTP sent", Toast.LENGTH_LONG)
                                .show()
                            verificationCode = p0
                            forceResendingToken = p1

                        }
                    })
        if (isResend) {//it is coming after resend
            PhoneAuthProvider.verifyPhoneNumber(
                builder.setForceResendingToken(forceResendingToken).build()
            )
        } else {
            //it is the first time
            PhoneAuthProvider.verifyPhoneNumber(builder.build())
        }

    }


    private fun signIn(p0: PhoneAuthCredential) {
//        login and go to main Activity
//        countDown()
        mFirebaseAuth.signInWithCredential(p0).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this, "Login successful", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
//                can put something in putExtra here
                finish()
                startActivity(intent)
            } else {
                Toast.makeText(this, "Login failed", Toast.LENGTH_LONG).show()
            }
        }
    }
}