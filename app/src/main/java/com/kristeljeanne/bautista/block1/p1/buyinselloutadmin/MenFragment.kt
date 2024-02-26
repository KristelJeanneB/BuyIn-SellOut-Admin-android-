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
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.databinding.FragmentMenBinding


class MenFragment : Fragment() {
    private lateinit var binding: FragmentMenBinding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenBinding.inflate(inflater, container, false)
        val recyclerView: RecyclerView = binding.root.findViewById(R.id.recyclerView)

        val cardItems = listOf(
            CardItem(11, "Skincare for men\nP999", R.drawable.menproduct1),
            CardItem(12, "Skincare for men\nP999", R.drawable.menproduct1),
            CardItem(13, "Skincare for men\nP999", R.drawable.menproduct1),
            CardItem(14, "Skincare for men\nP999", R.drawable.menproduct1),
            CardItem(15, "Skincare for men\nP999", R.drawable.menproduct1),
            CardItem(16, "Skincare for men\nP999", R.drawable.menproduct1),


            )

        val adapter = CardItemAdapter(cardItems){ itemId ->
            when(itemId) {
                11 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Men11Fragment())
                        .addToBackStack(null)
                        .commit()
                }
                12 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Men12Fragment())
                        .addToBackStack(null)
                        .commit()
                }
                13 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Men13Fragment())
                        .addToBackStack(null)
                        .commit()
                }
                14 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Men14Fragment())
                        .addToBackStack(null)
                        .commit()
                }
                15 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Men15Fragment())
                        .addToBackStack(null)
                        .commit()
                }
                16 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Men16Fragment())
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