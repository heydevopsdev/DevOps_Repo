package com.example.housemartapplication

import android.Manifest
import android.annotation.SuppressLint
import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.housemartapplication.databinding.FragmentLocationPermissionBottomSheetBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.vmadalin.easypermissions.EasyPermissions
import com.vmadalin.easypermissions.dialogs.SettingsDialog

class LocationPermissionBottomSheetFrag : BottomSheetDialogFragment(),
    EasyPermissions.PermissionCallbacks {
    companion object {
        const val REQUEST_LOCATION_CODE = 123123
    }

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    private var _binding: FragmentLocationPermissionBottomSheetBinding? = null
    private val binding get() = _binding!!


//    override
//    fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
//
//    }

    @SuppressLint("MissingPermission")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
//        val view: View = inflater.inflate(
//            R.layout.fragment_location_permission_bottom_sheet, container, false
//        )
        inflater.inflate(R.layout.fragment_location_permission_bottom_sheet, container, false)
        _binding = FragmentLocationPermissionBottomSheetBinding.inflate(
            inflater, container, false
        )

        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(requireContext())


        //changes here
        binding.grantLocationButton.setOnClickListener {
            if (hasLocationPermission()) {
                Toast.makeText(requireContext(), "Permission already granted", Toast.LENGTH_SHORT)
                    .show()
//            supressLint iski vjh se lgaya h, isko first time likhte vakt hota h aisa error show
                fusedLocationProviderClient.lastLocation.addOnSuccessListener { location ->

                    val geocoder = Geocoder(requireContext())
                    val currLocation =
                        geocoder.getFromLocation(location.latitude, location.longitude, 1)
                    Log.d("LocationPermission latitude", location.latitude.toString())
                    Log.d("LocationPermission longitude", location.longitude.toString())
                    Log.d("LocationPermission location", currLocation!!.first().countryCode)
                    Log.d("LocationPermission location", currLocation.first().adminArea)
                    Log.d("LocationPermission location", currLocation.first().locality)
                    Log.d("LocationPermission location", currLocation.first().postalCode)
                }

            } else {
                requestLocationPermission()
            }
        }
        return binding.root


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    private fun hasLocationPermission(): Boolean = EasyPermissions.hasPermissions(
        requireContext(), Manifest.permission.ACCESS_FINE_LOCATION
    )

    private fun requestLocationPermission() {
        EasyPermissions.requestPermissions(
            this, "This app needs access to your location to know where you are.",
            REQUEST_LOCATION_CODE, Manifest.permission.ACCESS_FINE_LOCATION
        )
    }


    override fun onPermissionsDenied(requestCode: Int, perms: List<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            SettingsDialog.Builder(requireActivity()).build().show()
        } else {
            requestLocationPermission()
        }
    }

    override fun onPermissionsGranted(requestCode: Int, perms: List<String>) {
        Toast.makeText(requireContext(), "Permission granted", Toast.LENGTH_SHORT).show()
//        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
//            if (location != null) {
//                // Got last known location. In some rare situations this can be null.
//                val latitude = location.latitude
//                val longitude = location.longitude
//                // Do something with the location.
//            }
//        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}