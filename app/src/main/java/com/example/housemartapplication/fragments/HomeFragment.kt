package com.example.housemartapplication.fragments

import ProductViewModel
import ShopAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.housemartapplication.R
import com.example.housemartapplication.listeners.RecyclerItemClickListener
import com.example.housemartapplication.model.Shop


class HomeFragment : Fragment() {


    lateinit var product: ProductViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var rootView: View

    companion object {
        var pos: String = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        rootView = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = rootView.findViewById(R.id.rvShops)
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        product = ViewModelProvider(this).get(ProductViewModel::class.java)
        product.getProductLiveData().observe(requireActivity()) { contacts ->
//            userFoodItemCustomAdapter.setTaskList(contacts)

            var listOfShop: MutableList<Shop> = mutableListOf()
            for (i in 0 until contacts.size) {
                listOfShop.add(
                    Shop(
                        R.drawable.ic_shop_1,
                        contacts.get(i).vendor.vendorName,
                        "34km",
                        "4.1"
                    )
                )
            }
            var shopAdapter = ShopAdapter(listOfShop)
            recyclerView.adapter = shopAdapter
            recyclerView.addOnItemTouchListener(
                RecyclerItemClickListener(
                    requireContext(),
                    recyclerView,
                    object : RecyclerItemClickListener.OnItemClickListener {
                        override fun onItemClick(view: View, position: Int) {
                            // Handle item click
                            pos = contacts.get(position).vendor.gstNumber.toString()
                            parentFragmentManager.beginTransaction()
//                                .replace(R.id.frameLayout, ShopItemFragment())
//                                .replace(R.id.frameLayout, ShopItemFragment())
                            findNavController().navigate(R.id.action_homeFragment_to_shopItemFragment)
//                                .addToBackStack(null)
//                                .commit()
                        }

                        override fun onLongItemClick(view: View, position: Int) {
                            // Handle item long click

                        }
                    })
            )
        }





        return rootView
    }


}