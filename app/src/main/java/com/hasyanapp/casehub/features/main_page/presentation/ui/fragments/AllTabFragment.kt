package com.hasyanapp.casehub.features.main_page.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hasyanapp.casehub.databinding.FragmentAllBarBinding


class AllTabFragment : Fragment() {

    private var _binding: FragmentAllBarBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAllBarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchViewAllBar.setIconifiedByDefault(false) //Раскрываем поисковик
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}