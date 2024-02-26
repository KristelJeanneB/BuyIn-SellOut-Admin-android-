package com.kristeljeanne.bautista.block1.p1.buyinselloutadmin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.databinding.FragmentAccesoriesBinding
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.databinding.FragmentKids1Binding
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.databinding.FragmentKidsBinding
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.databinding.FragmentMenBinding
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.databinding.FragmentWomenBinding


class AccesoriesFragment : Fragment() {
    private lateinit var binding: FragmentAccesoriesBinding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAccesoriesBinding.inflate(inflater, container, false)
        val recyclerView: RecyclerView = binding.root.findViewById(R.id.recyclerView)

        val cardItems = listOf(
            CardItem(51, "Unisex Bracelet\nP299", R.drawable.accesoriesproduct1),
            CardItem(52, "Unisex Bracelet\nP299", R.drawable.accesoriesproduct1),
            CardItem(53, "Unisex Bracelet\nP299", R.drawable.accesoriesproduct1),
            CardItem(54, "Unisex Bracelet\nP299", R.drawable.accesoriesproduct1),
            CardItem(55, "Unisex Bracelet\nP299", R.drawable.accesoriesproduct1),
            CardItem(56, "Unisex Bracelet\nP299", R.drawable.accesoriesproduct1),


            )

        val adapter = CardItemAdapter(cardItems){ itemId ->
            when(itemId) {
                51 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Accesories51Fragment())
                        .addToBackStack(null)
                        .commit()
                }
                52 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Accesories52Fragment())
                        .addToBackStack(null)
                        .commit()
                }
                53 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Accesories53Fragment())
                        .addToBackStack(null)
                        .commit()
                }
                54 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Accesories54Fragment())
                        .addToBackStack(null)
                        .commit()
                }
                55 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Accesories55Fragment())
                        .addToBackStack(null)
                        .commit()
                }
                56 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Accesories56Fragment())
                        .addToBackStack(null)
                        .commit()
                }
            }


        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)



        return binding.root
    }



}