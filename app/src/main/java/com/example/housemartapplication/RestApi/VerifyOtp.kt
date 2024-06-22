package com.example.housemartapplication.RestApi

import android.content.Context
import android.util.Base64
import android.util.Log
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.housemartapplication.auth.userauth.UserSignUpActivity
import org.json.JSONObject
import java.util.HashMap

class VerifyOtp {

    lateinit var context: Context

    constructor(context: Context, to: String, code: String) {
        this.context = context
        Log.d(".....<<>>", to + "      " + code);

        if (!to.startsWith("+91")) verifyCode("+91" + to, code)
        else verifyCode(to, code)
    }

    private fun verifyCode(to: String, code: String) {
        Log.d("<<<>>>", to + "     " + code + UserSignUpActivity.serviceSid)

        val url =
            "https://verify.twilio.com/v2/Services/${UserSignUpActivity.serviceSid}/VerificationCheck"

        // Create a request queue
        val queue = Volley.newRequestQueue(context)

        // Create the POST request
        val postRequest =
            object : StringRequest(Request.Method.POST, url, Response.Listener { response ->
                // Handle response
                val jsonObject = JSONObject(response.toString())
                Log.d("<<<>>>", response.toString())
                val status: String = jsonObject.getString("status")
                Log.d("<<<>>>", status)

                if (status.equals("pending")) {
                    Toast.makeText(context, "Wrong otp", Toast.LENGTH_LONG).show()
                } else {
                    verifyJWTToken()
                }
            }, Response.ErrorListener { error ->
                // Handle error

                Toast.makeText(context, "verification failed", Toast.LENGTH_LONG).show()

                if (error is AuthFailureError) {
                    Log.e("<<<>>>", "Auth Failure Error: ${error.message}")
                } else {
                    Log.e("<<<>>>", "Error: $error")
                }
            }) {
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
                    params["To"] = to
                    params["Code"] = code
                    return params
                }
            }

        // Add the request to the request queue
        queue.add(postRequest)
    }

    private fun verifyJWTToken() {
        val requestQueue: RequestQueue = Volley.newRequestQueue(context)
        val url = "https://06e4-152-58-101-12.ngrok-free.app/api/customer/auth"
        val jsonBody = JSONObject()
        jsonBody.put("phoneNumber", UserSignUpActivity.number)
        jsonBody.put("isCustomer", true)
        val jsonObjectRequest = JsonObjectRequest(Request.Method.POST, url, jsonBody, { response ->
            Toast.makeText(context, "verification Success", Toast.LENGTH_LONG).show()
            println("Response: $response")
        }, { error ->
            Toast.makeText(context, "Token Not Created", Toast.LENGTH_LONG).show()
        })
        // Add the request to the request queue
        requestQueue.add(jsonObjectRequest)
    }


}