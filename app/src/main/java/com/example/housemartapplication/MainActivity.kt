package com.example.housemartapplication

import ProductViewModel
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.housemartapplication.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var product: ProductViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.btmNavigationView)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        val locationPermissionBottomSheetFrag = LocationPermissionBottomSheetFrag()

//        cancellable yha se hta dena baad me
//        locationPermissionBottomSheetFrag.isCancelable = false


        locationPermissionBottomSheetFrag.show(
            supportFragmentManager,
            "locationPermissionBottomSheetFrag"
        )

//    bottomNavigationView.setupWithNavController(navController)
        bottomNavigationView.setupWithNavController(navController)
        HelperClass.context = this


//        true

    }


}
