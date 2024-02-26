package com.kristeljeanne.bautista.block1.p1.buyinselloutadmin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.databinding.FragmentKids1Binding
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.databinding.FragmentKidsBinding


class KidsFragment : Fragment() {
    private lateinit var binding: FragmentKidsBinding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKidsBinding.inflate(inflater, container, false)
        val recyclerView: RecyclerView = binding.root.findViewById(R.id.recyclerView)

        val cardItems = listOf(
            CardItem(1, "Kids Toys\nP1999", R.drawable.kidsproduct1),
            CardItem(2, "Kids Toys\nP1999", R.drawable.kidsproduct1),
            CardItem(3, "Kids Toys\nP1999", R.drawable.kidsproduct1),
            CardItem(4, "Kids Toys\nP1999", R.drawable.kidsproduct1),
            CardItem(5, "Kids Toys\nP1999", R.drawable.kidsproduct1),
            CardItem(6, "Kids Toys\nP1999", R.drawable.kidsproduct1),


        )

        val adapter = CardItemAdapter(cardItems){ itemId ->
            when(itemId) {
                1 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Kids1Fragment())
                        .addToBackStack(null)
                        .commit()
                }
                2 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Kids2Fragment())
                        .addToBackStack(null)
                        .commit()
                }
                3 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Kids3Fragment())
                        .addToBackStack(null)
                        .commit()
                }
                4 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Kids4Fragment())
                        .addToBackStack(null)
                        .commit()
                }
                5 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Kids5Fragment())
                        .addToBackStack(null)
                        .commit()
                }
                6 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Kids6Fragment())
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