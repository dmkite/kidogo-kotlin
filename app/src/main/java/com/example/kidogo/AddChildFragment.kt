package com.example.kidogo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.navGraphViewModels
import com.example.kidogo.databinding.FragmentAddChildBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddChildFragment: Fragment() {
//    private val viewModel: AddChildViewModel = ViewModelProvider(this).get(AddChildViewModel::class.java)
    private val viewModel: AddChildViewModel by viewModels()
    private var _binding: FragmentAddChildBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddChildBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.saveButton.setOnClickListener {
            viewModel.doThing()
        }
        binding.saveButton.setEnabled(false)
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel.firstName.observe(viewLifecycleOwner) {
//            // update UI
//            binding.firstnameInput.text = viewModel.firstName
//        }
    }
}