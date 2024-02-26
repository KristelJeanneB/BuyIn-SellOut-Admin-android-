package com.kristeljeanne.bautista.block1.p1.buyinselloutadmin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.databinding.FragmentApplianceBinding
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.databinding.FragmentKids1Binding
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.databinding.FragmentKidsBinding
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.databinding.FragmentMenBinding
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.databinding.FragmentWomenBinding


class ApplianceFragment : Fragment() {
    private lateinit var binding: FragmentApplianceBinding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentApplianceBinding.inflate(inflater, container, false)
        val recyclerView: RecyclerView = binding.root.findViewById(R.id.recyclerView)

        val cardItems = listOf(
            CardItem(31, "Microwave Oven\nP4999", R.drawable.applianceproduct1),
            CardItem(32, "Microwave Oven\nP4999", R.drawable.applianceproduct1),
            CardItem(33, "Microwave Oven\nP4999", R.drawable.applianceproduct1),
            CardItem(34, "Microwave Oven\nP4999", R.drawable.applianceproduct1),
            CardItem(35, "Microwave Oven\nP4999", R.drawable.applianceproduct1),
            CardItem(36, "Microwave Oven\nP4999", R.drawable.applianceproduct1),


            )

        val adapter = CardItemAdapter(cardItems){ itemId ->
            when(itemId) {
                31 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Appliance31Fragment())
                        .addToBackStack(null)
                        .commit()
                }
                32 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container,Appliance32Fragment())
                        .addToBackStack(null)
                        .commit()
                }
                33 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Appliance33Fragment())
                        .addToBackStack(null)
                        .commit()
                }
                34 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Appliance34Fragment())
                        .addToBackStack(null)
                        .commit()
                }
                35 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Appliance35Fragment())
                        .addToBackStack(null)
                        .commit()
                }
                36 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Appliance36Fragment())
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