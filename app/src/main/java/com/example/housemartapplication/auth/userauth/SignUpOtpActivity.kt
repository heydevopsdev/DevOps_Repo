package com.example.housemartapplication.auth.userauth

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.provider.Settings.Secure
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.housemartapplication.MainActivity
import com.example.housemartapplication.R
import com.example.housemartapplication.auth.vendorauth.VendorSignUpActivity
import com.example.housemartapplication.auth.vendorauth.VendorSignUpActivity2
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import org.json.JSONObject


class SignUpOtpActivity : AppCompatActivity() {
    private lateinit var mobileFetchTextView: TextView
    private lateinit var verifyOTPButton: Button

    //    private lateinit var otpEditText: EditText
    private lateinit var txtResendTime: TextView
    private lateinit var resendOtpTextView: TextView
    private lateinit var txtResendText: TextView
    private lateinit var llOtpSection: LinearLayout
    private lateinit var otpTextInputEt: TextInputEditText
    val TAG = "<<<>>>"


    val mFirebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    lateinit var verificationCode: String
    lateinit var forceResendingToken: PhoneAuthProvider.ForceResendingToken


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_sign_up_otp)

        mobileFetchTextView = findViewById(R.id.mobileFetchTextView)
        txtResendText = findViewById(R.id.txtResendText)
        verifyOTPButton = findViewById(R.id.verifyOTPButton)
        txtResendTime = findViewById(R.id.txtResendTime)
        resendOtpTextView = findViewById(R.id.resendOtpTextView)
        llOtpSection = findViewById(R.id.llOtpSection)
        otpTextInputEt = findViewById(R.id.otpTextInputEt)


        val number = intent.getStringExtra("MOBILE_NUMBER_SIGN_UP")

        mobileFetchTextView.text = number

        if (number != null) {
            sendFirebaseOtp(mobileNumber = number, isResend = false)
        }


        verifyOTPButton.setOnClickListener {
//            Log.d(".....<<>>", otpTextInputEt.text.toString());
//            Toast.makeText(this, otpTextInputEt.text.toString(), Toast.LENGTH_LONG).show()
            //
            //twilio api
//            var verifyCode =VerifyOtp(this, UserSignUpActivity.number, otpTextInputEt.text.toString())

//            Toast.makeText(this, SignInActivity.mobileNumber, Toast.LENGTH_LONG).show()
            val enteredOTP = otpTextInputEt.text.toString()
            var phoneAuthCredential =
                PhoneAuthProvider.getCredential(verificationCode, enteredOTP)
            signIn(phoneAuthCredential)

        }

        resendOtpTextView.setOnClickListener {
//            var sendOtp = ResendOtp(this)
            if (number != null) {
                sendFirebaseOtp(mobileNumber = number, isResend = true)
            }

        }
//        countDown()
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
                                this@SignUpOtpActivity, "Verification failed", Toast.LENGTH_LONG
                            ).show()
                        }

                        override fun onCodeSent(
                            p0: String, p1: PhoneAuthProvider.ForceResendingToken
                        ) {
                            Log.d(TAG, "onCodeSent: $p0")
                            Toast.makeText(this@SignUpOtpActivity, "OTP sent", Toast.LENGTH_LONG)
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
                //backend api
                sendSignUpRequest(this)
                startActivity(intent)
//                finish()
            } else {
                Toast.makeText(this, "Login failed", Toast.LENGTH_LONG).show()
            }
        }
    }


    fun sendSignUpRequest(context: Context) {
        val url =
            "https://7567-2409-4085-2db2-4762-6555-5029-8c04-43bb.ngrok-free.app/api/vendor/signup"

        // Create the request body as a JSON object
        val requestBody = JSONObject()
        requestBody.put("vendorName", VendorSignUpActivity.name)
        requestBody.put("shopName", VendorSignUpActivity.shopName)
        requestBody.put("gstNumber", VendorSignUpActivity.gstNo)
        requestBody.put("shopPhoneNumber", VendorSignUpActivity.number)
        //ye logo kya h vendor m?
        requestBody.put(
            "logo", ""
        )
        //ye unique chije baad m..
//        ip over network?
//        requestBody.put("ipAddress", getIMEI(this))
        requestBody.put("ipAddress", "DekhteHaiBhaiBaadMe")
        requestBody.put("device", getDeviceUniqueID(this))

        val address = JSONObject()
        address.put("addressLine1", VendorSignUpActivity2.shopAddress)
        address.put("addressLine2", "")
        address.put("city", VendorSignUpActivity2.city)
        address.put("state", VendorSignUpActivity2.state)
        address.put("pinCode", VendorSignUpActivity2.pinCode.toInt())
        address.put("country", "India")

        requestBody.put("address", address)

        // Create a Volley request queue
        val requestQueue: RequestQueue = Volley.newRequestQueue(context)

        // Create the POST request
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.POST,
            url,
            requestBody,
            { response ->
                // Handle the response
                val vendorId = response.getInt("vendorId")
                val phoneNumber = response.getString("phoneNumber")
                val accessToken = response.getString("accessToken")
                val refreshToken = response.getString("refreshToken")

                // Do something with the response data
                println("Vendor ID: $vendorId")
                Log.d("<<<<<<<<<<<", vendorId.toString())
                println("Phone Number: $phoneNumber")
                Log.d("<<<<<<<<<<<", phoneNumber)
                println("Access Token: $accessToken")
                Log.d("<<<<<<<<<<<", accessToken)
                println("Refresh Token: $refreshToken")
                Log.d("<<<<<<<<<<<", refreshToken)

                // Save the access token and refresh token in shared preferences
//                val sharedPreferences = context.getSharedPreferences(
//                    "com.example.housemartapplication",
//                    Context.MODE_PRIVATE
//                )

            },
            { error ->
                // Handle the error
                Log.e("<<<<<<<<<<<<<", "Error occurred: $error")
                error.printStackTrace()
            }
        )

        // Add the request to the request queue
        requestQueue.add(jsonObjectRequest)
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

//    fun getIMEI(activity: Activity): String {
//        val telephonyManager = activity
//            .getSystemService(TELEPHONY_SERVICE) as TelephonyManager
//        return telephonyManager.deviceId
//    }

    fun getDeviceUniqueID(activity: Activity): String {
        val device_unique_id = Secure.getString(
            activity.contentResolver,
            Secure.ANDROID_ID
        )
        return device_unique_id
    }
}