package com.example.housemartapplication.RestApi

import android.content.Context
import android.util.Base64
import android.util.Log
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.housemartapplication.auth.userauth.UserSignUpActivity
import org.json.JSONException
import org.json.JSONObject
import java.util.HashMap

class ResendOtp {

    lateinit var context : Context

    constructor(context: Context){
        this.context = context
        createService("MyServiceName")
    }
    private fun createService(friendlyName: String) {
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
                    sendVerification(UserSignUpActivity.number, "sms")
                } catch (e: JSONException) {
                    throw RuntimeException(e)
                }
                Log.d("<<<>>>>", "Response: $response")
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
                val credentials = "${UserSignUpActivity.TWILIO_ACCOUNT_SID}:${UserSignUpActivity.TWILIO_AUTH_TOKEN}"
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
        val url = "https://verify.twilio.com/v2/Services/${UserSignUpActivity.serviceSid}/Verifications"

        // Create a request queue
        val queue = Volley.newRequestQueue(context)

        // Create the POST request
        val postRequest = object : StringRequest(
            Request.Method.POST, url,
            Response.Listener { response ->
                // Handle response
                Toast.makeText(context, "OTP Resent", Toast.LENGTH_LONG).show()
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
                val credentials = "${UserSignUpActivity.TWILIO_ACCOUNT_SID}:${UserSignUpActivity.TWILIO_AUTH_TOKEN}"
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