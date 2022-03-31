package ru.vadya.calculator.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ru.vadya.calculator.R
import ru.vadya.calculator.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            calculatorOpen.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_calculatorFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
