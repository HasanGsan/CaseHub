package com.hasyanapp.casehub.features.workshop_page.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hasyanapp.casehub.databinding.FragmentPublishedBarBinding

class PublishedTabsFragment : Fragment() {

    private var _binding: FragmentPublishedBarBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPublishedBarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchViewWorkshop.setIconifiedByDefault(false) //Раскрываем поисковик
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}