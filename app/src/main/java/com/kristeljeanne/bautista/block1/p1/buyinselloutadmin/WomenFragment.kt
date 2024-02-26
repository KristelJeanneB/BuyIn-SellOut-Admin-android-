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
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.databinding.FragmentWomenBinding


class WomenFragment : Fragment() {
    private lateinit var binding: FragmentWomenBinding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWomenBinding.inflate(inflater, container, false)
        val recyclerView: RecyclerView = binding.root.findViewById(R.id.recyclerView)

        val cardItems = listOf(
            CardItem(21, "Hair Treatment Set\nP999", R.drawable.womenproduct1),
            CardItem(22, "Hair Treatment Set\nP999", R.drawable.womenproduct1),
            CardItem(23, "Hair Treatment Set\nP999", R.drawable.womenproduct1),
            CardItem(24, "Hair Treatment Set\nP999", R.drawable.womenproduct1),
            CardItem(25, "Hair Treatment Set\nP999", R.drawable.womenproduct1),
            CardItem(26, "Hair Treatment Set\nP999", R.drawable.womenproduct1),


            )

        val adapter = CardItemAdapter(cardItems){ itemId ->
            when(itemId) {
                21 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Women21Fragment())
                        .addToBackStack(null)
                        .commit()
                }
                22 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Women22Fragment())
                        .addToBackStack(null)
                        .commit()
                }
                23 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Women23Fragment())
                        .addToBackStack(null)
                        .commit()
                }
                24 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Women24Fragment())
                        .addToBackStack(null)
                        .commit()
                }
                25 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Women25Fragment())
                        .addToBackStack(null)
                        .commit()
                }
                26 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Women26Fragment())
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