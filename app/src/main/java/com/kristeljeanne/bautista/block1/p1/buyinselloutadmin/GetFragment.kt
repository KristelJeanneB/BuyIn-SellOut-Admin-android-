package com.kristeljeanne.bautista.block1.p1.buyinselloutadmin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.Api.Api
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.Api.RetrofitClient
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.databinding.FragmentGetBinding
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.model.Products
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class GetFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_get, container, false)

        recyclerView = view.findViewById(R.id.recyclerView1)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        fetchProductsFromApi()

        return view
    }

    private fun fetchProductsFromApi() {
        val retrofit = RetrofitClient.getRetrofit()
        val productsApi = retrofit.create(Api::class.java)

        // Use CoroutineScope to launch a coroutine
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val products = productsApi.getProducts()
                // Assuming that the call does not throw an exception,
                // the coroutine will only proceed if the call is successful
                // So, we can safely assume that the products are retrieved successfully here
                updateUI(products)
            } catch (e: Exception) {
                // Handle network errors
                Log.e("ProductFragment", "Error fetching products", e)
            }
        }
    }

    private fun updateUI(products: List<Products>) {
        // Populate the RecyclerView with fetched products
        productAdapter = ProductAdapter(products)
        recyclerView.adapter = productAdapter
    }

}