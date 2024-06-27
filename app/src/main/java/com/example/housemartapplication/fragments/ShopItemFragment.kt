package com.example.housemartapplication.fragments

import ProductAdapter
import ProductAdapterItem
import ProductViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.housemartapplication.R


class ShopItemFragment : Fragment() {
    lateinit var product: ProductViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_product, container, false)

        recyclerView = rootView.findViewById(R.id.rvProducts)
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
//
        product = ViewModelProvider(this).get(ProductViewModel::class.java)
//
        product.getProductLiveData().observe(requireActivity()) { contacts ->
            var listOfProduct: MutableList<ProductAdapterItem> = mutableListOf()
////
            for (i in 0 until contacts.size) {
                if (contacts.get(i).vendor.gstNumber.equals(HomeFragment.pos)) {
                    listOfProduct.add(
                        ProductAdapterItem(
                            contacts[i].images,
                            contacts[i].productName,
                            contacts[i].unitPrice,
                            contacts[i].reviews,
                            contacts[i].reviews
                        )
                    )
                }
            }
            var shopAdapter = ProductAdapter(listOfProduct)

            recyclerView.adapter = shopAdapter
        }

        return rootView
    }
}