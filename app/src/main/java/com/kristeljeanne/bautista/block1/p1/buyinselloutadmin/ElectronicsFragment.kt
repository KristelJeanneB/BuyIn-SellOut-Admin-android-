package com.kristeljeanne.bautista.block1.p1.buyinselloutadmin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.databinding.FragmentElectronicsBinding
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.databinding.FragmentKids1Binding
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.databinding.FragmentKidsBinding


class ElectronicsFragment : Fragment() {
    private lateinit var binding: FragmentElectronicsBinding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentElectronicsBinding.inflate(inflater, container, false)
        val recyclerView: RecyclerView = binding.root.findViewById(R.id.recyclerView)

        val cardItems = listOf(
            CardItem(41, "Office Laptop\nP18,999", R.drawable.electronicsproduct1),
            CardItem(42, "Office Laptop\nP18,999", R.drawable.electronicsproduct1),
            CardItem(43, "Office Laptop\nP18,999", R.drawable.electronicsproduct1),
            CardItem(44, "Office Laptop\nP18,999", R.drawable.electronicsproduct1),
            CardItem(45, "Office Laptop\nP18,999", R.drawable.electronicsproduct1),
            CardItem(46, "Office Laptop\nP18,999", R.drawable.electronicsproduct1),


            )

        val adapter = CardItemAdapter(cardItems){ itemId ->
            when(itemId) {
                41 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Electronics41Fragment())
                        .addToBackStack(null)
                        .commit()
                }
                42 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Electronics42Fragment())
                        .addToBackStack(null)
                        .commit()
                }
                43 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Electronics43Fragment())
                        .addToBackStack(null)
                        .commit()
                }
                44 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Electronics44Fragment())
                        .addToBackStack(null)
                        .commit()
                }
                45 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Electronics45Fragment())
                        .addToBackStack(null)
                        .commit()
                }
                46 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Electronics46Fragment())
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