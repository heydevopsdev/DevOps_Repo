package com.example.housemartapplication.RestApi

import android.content.Context
import android.content.Intent
import android.util.Base64
import android.util.Log
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.housemartapplication.auth.userauth.SignUpOtpActivity
import com.example.housemartapplication.auth.userauth.UserSignUpActivity
import org.json.JSONException
import org.json.JSONObject

class SendOtp {

    lateinit var context: Context
    lateinit var mobileNumber: String

    constructor(context: Context, mobileNumber: String) {
        this.context = context
        this.mobileNumber = mobileNumber
        createService("MyServiceName")
    }

    private fun createService(friendlyName: String) {

//        if (UserSignUpActivity.validateMobileNumber(mobileNumber)) return
        val url = "https://verify.twilio.com/v2/Services"

        // Create a request queue
        val queue = Volley.newRequestQueue(context)

        // Create the POST request
        val postRequest = object : StringRequest(
            Request.Method.POST, url,
            Response.Listener { response ->
                // Handle response
                try {
                    val jsonObject = JSONObject(response)
                    UserSignUpActivity.serviceSid = jsonObject.getString("sid")
                    Log.d("......<<<>>>", UserSignUpActivity.serviceSid)

                    sendVerification("+91" + mobileNumber.toString(), "sms")
                } catch (e: JSONException) {
                    throw RuntimeException(e)
                }
                Log.d("<<<>>>", "Response: $response")
            },
            Response.ErrorListener { error ->
                // Handle error
                Log.e("<<<>>>", "Error: $error")
            }
        ) {
            @Throws(AuthFailureError::class)
            override fun getHeaders(): Map<String, String> {
                // Add headers
                val headers = HashMap<String, String>()
                val credentials =
                    "${UserSignUpActivity.TWILIO_ACCOUNT_SID}:${UserSignUpActivity.TWILIO_AUTH_TOKEN}"
                val auth =
                    "Basic " + Base64.encodeToString(credentials.toByteArray(), Base64.NO_WRAP)
                headers["Authorization"] = auth
                return headers
            }

            override fun getParams(): Map<String, String> {
                // Add parameters
                val params = HashMap<String, String>()
                params["FriendlyName"] = friendlyName
                return params
            }
        }

        // Add the request to the request queue
        queue.add(postRequest)
    }

    private fun sendVerification(to: String, channel: String) {
        val url =
            "https://verify.twilio.com/v2/Services/${UserSignUpActivity.serviceSid}/Verifications"

        // Create a request queue
        val queue = Volley.newRequestQueue(context)

        // Create the POST request
        val postRequest = object : StringRequest(
            Request.Method.POST, url,
            Response.Listener { response ->
                // Handle response
                Toast.makeText(context, "OTP Sent", Toast.LENGTH_LONG).show()
                var intent = Intent(context, SignUpOtpActivity::class.java)
                context.startActivity(intent)
                Log.d("<<<>>>", "Response: $response")
            },
            Response.ErrorListener { error ->
                // Handle error
                Toast.makeText(context, "Something went wrong", Toast.LENGTH_LONG).show()
                if (error is AuthFailureError) {
                    Log.e("<<<>>>", "Auth Failure Error: ${error.message}")
                } else {
                    Log.e("<<<>>>", "Error: $error")
                }
            }
        ) {
            @Throws(AuthFailureError::class)
            override fun getHeaders(): Map<String, String> {
                // Add headers
                val headers = HashMap<String, String>()
                val credentials =
                    "${UserSignUpActivity.TWILIO_ACCOUNT_SID}:${UserSignUpActivity.TWILIO_AUTH_TOKEN}"
                val auth =
                    "Basic " + Base64.encodeToString(credentials.toByteArray(), Base64.NO_WRAP)
                headers["Authorization"] = auth
                Log.d("<<<>>>", "Authorization: $auth")
                return headers
            }

            override fun getParams(): Map<String, String> {
                // Add parameters
                val params = HashMap<String, String>()
                params["To"] = to
                params["Channel"] = channel
                return params
            }
        }

        // Add the request to the request queue
        queue.add(postRequest)
    }


}