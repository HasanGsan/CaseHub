package com.hasyanapp.casehub.features.workshop_page.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.hasyanapp.casehub.features.workshop_page.presentation.ui.adapters.WorkshopTabsAdapter
import com.google.android.material.tabs.TabLayout
import com.hasyanapp.casehub.databinding.FragmentWorkshopBinding


class WorkshopContainerFragment : Fragment() {

    private var _binding: FragmentWorkshopBinding? = null
    private val binding
        get() = _binding!!

    private lateinit var adapter: WorkshopTabsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWorkshopBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var tabLayout = binding.workshopTabLayout
        var viewPager = binding.viewPagerWorkshop

        adapter = WorkshopTabsAdapter(childFragmentManager, lifecycle)

        tabLayout.addTab(tabLayout.newTab().setText("Опубликованные"))
        tabLayout.addTab(tabLayout.newTab().setText("Черновики"))

        viewPager.adapter = adapter

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if(tab != null){
                    viewPager.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })

    }

}