package com.example.housemartapplication.auth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.housemartapplication.R
import com.example.housemartapplication.auth.userauth.UserSignUpActivity
import com.example.housemartapplication.auth.vendorauth.VendorSignUpActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BottomSheetFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BottomSheetFragment : BottomSheetDialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_bottom_sheet, container, false)

        view.findViewById<Button>(R.id.signUpUserBtn).setOnClickListener {
            startActivity(Intent(activity, UserSignUpActivity::class.java))

        }
        view.findViewById<Button>(R.id.signUpVendorBtn).setOnClickListener {
            startActivity(Intent(activity, VendorSignUpActivity::class.java))

        }
        view.findViewById<TextView>(R.id.signInTextView).setOnClickListener {
            // TODO: sign in activity for user and vendor both (single or separate separate)
        }
        return view
    }

}