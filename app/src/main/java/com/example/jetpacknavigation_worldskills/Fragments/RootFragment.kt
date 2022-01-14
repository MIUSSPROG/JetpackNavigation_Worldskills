package com.example.jetpacknavigation_worldskills.Fragments

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.jetpacknavigation_worldskills.Fragments.BoxFragment.Companion.EXTRA_RANDOM_NUMBER
import com.example.jetpacknavigation_worldskills.Fragments.BoxFragment.Companion.REQUEST_CODE
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

        parentFragmentManager.setFragmentResultListener(REQUEST_CODE, viewLifecycleOwner){ code, data ->
            val number = data.getInt(EXTRA_RANDOM_NUMBER)
            Toast.makeText(requireContext(), "Generated number: $number ${getString(R.string.lorem)}", Toast.LENGTH_SHORT).show()
        }

    }

    private fun openBox(color: Int, colorName: String){
        val direction = RootFragmentDirections.actionRootFragmentToBoxFragment(colorName=colorName, color=color)
        findNavController().navigate(
            direction,
            navOptions {
                anim {
                    enter = R.anim.enter
                    exit = R.anim.exit
                    popEnter = R.anim.pop_enter
                    popExit = R.anim.pop_exit
                }
            }
        )
    }
}