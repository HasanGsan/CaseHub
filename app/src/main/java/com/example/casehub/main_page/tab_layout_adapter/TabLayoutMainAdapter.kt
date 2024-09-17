package com.example.casehub.main_page.tab_layout_adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.casehub.main_page.tab_layout_adapter.tab_fragment.all_bar
import com.example.casehub.main_page.tab_layout_adapter.tab_fragment.favorite_bar

class TabLayoutMainAdapter (
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
) : FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if(position == 0)
            all_bar()
        else
            favorite_bar()
    }

}