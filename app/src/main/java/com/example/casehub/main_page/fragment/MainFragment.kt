package com.example.casehub.main_page.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.casehub.databinding.FragmentMainBinding
import com.example.casehub.main_page.tab_main_adapter.TabMainAdapter
import com.google.android.material.tabs.TabLayout


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding
        get() = _binding!!

    private lateinit var adapter: TabMainAdapter



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var tabLayout = binding.mainTabLayout
        var viewPager = binding.viewPagerMain

        adapter = TabMainAdapter(childFragmentManager, lifecycle)

        tabLayout.addTab(tabLayout.newTab().setText("Все"))
        tabLayout.addTab(tabLayout.newTab().setText("Избранные"))

        viewPager.adapter = adapter

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
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



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}