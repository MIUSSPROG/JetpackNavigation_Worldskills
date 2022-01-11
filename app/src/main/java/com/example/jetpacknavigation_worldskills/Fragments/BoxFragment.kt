package com.example.jetpacknavigation_worldskills.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.jetpacknavigation_worldskills.R
import com.example.jetpacknavigation_worldskills.databinding.FragmentBoxBinding

class BoxFragment : Fragment(R.layout.fragment_box) {

    private lateinit var binding: FragmentBoxBinding

    private val args: BoxFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentBoxBinding.bind(view)

        val color = args.color
        binding.root.setBackgroundColor(color)

        binding.btnGoBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }


}