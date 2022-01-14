package com.example.jetpacknavigation_worldskills.Fragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navOptions
import com.example.jetpacknavigation_worldskills.R
import com.example.jetpacknavigation_worldskills.databinding.FragmentBoxBinding
import kotlin.random.Random

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

        binding.btnGenerateNumber.setOnClickListener {
            val number = Random.nextInt(100)
            parentFragmentManager.setFragmentResult(REQUEST_CODE, bundleOf(EXTRA_RANDOM_NUMBER to number))
            findNavController().popBackStack()
        }

        binding.btnOpenSecret.setOnClickListener {
            findNavController().navigate(
                BoxFragmentDirections.actionBoxFragmentToSecretFragment(),
                navOptions {
                    anim {
                        enter = R.anim.enter
                        exit = R.anim.exit
                        popEnter = R.anim.pop_enter
                        popExit = R.anim.pop_exit
                    }
                })

        }
    }

    companion object{

        const val REQUEST_CODE = "RANDOM_NUMBER"
        const val EXTRA_RANDOM_NUMBER = "EXTRA_RANDOM_NUMBER"
    }

}