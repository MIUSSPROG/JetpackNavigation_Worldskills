package com.example.jetpacknavigation_worldskills.Fragments

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.jetpacknavigation_worldskills.R
import com.example.jetpacknavigation_worldskills.databinding.FragmentRootBinding

class RootFragment : Fragment(R.layout.fragment_root) {

    private lateinit var binding: FragmentRootBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRootBinding.bind(view)

        binding.btnOpenYellowBox.setOnClickListener {
            openBox(Color.rgb(255, 255, 200), "Yellow")
        }

        binding.btnOpenGreenBox.setOnClickListener {
            openBox(Color.rgb(200, 255, 255), "Green")
        }


    }

    private fun openBox(color: Int, colorName: String){
        val direction = RootFragmentDirections.actionRootFragmentToBoxFragment(colorName, color)
        findNavController().navigate(direction)
    }
}