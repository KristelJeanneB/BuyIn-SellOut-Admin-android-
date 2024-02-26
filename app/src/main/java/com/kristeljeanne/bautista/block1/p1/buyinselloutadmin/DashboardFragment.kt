package com.kristeljeanne.bautista.block1.p1.buyinselloutadmin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.databinding.FragmentDashboardBinding
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.databinding.FragmentKids1Binding


class DashboardFragment : Fragment() {
    private lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)

        binding.cardView2.setOnClickListener{
            val kidsFragment = KidsFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, kidsFragment)
                .addToBackStack(null)
                .commit()

        }
        binding.cardView3.setOnClickListener{
            val menFragment = MenFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, menFragment)
                .addToBackStack(null)
                .commit()

        }
        binding.cardView4.setOnClickListener{
            val womenFragment = WomenFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, womenFragment)
                .addToBackStack(null)
                .commit()

        }
        binding.cardView5.setOnClickListener {
            val applianceFragment = ApplianceFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, applianceFragment)
                .addToBackStack(null)
                .commit()
        }
        binding.cardView6.setOnClickListener {
            val electronicsFragment = ElectronicsFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, electronicsFragment)
                .addToBackStack(null)
                .commit()
        }
        binding.cardView7.setOnClickListener {
            val accesoriesFragment = AccesoriesFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, accesoriesFragment)
                .addToBackStack(null)
                .commit()
        }



        return binding.root
    }


}