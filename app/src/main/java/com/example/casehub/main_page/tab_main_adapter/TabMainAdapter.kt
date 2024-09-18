package com.example.casehub.main_page.tab_main_adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.casehub.main_page.tab_main_adapter.tab_fragments.AllBar
import com.example.casehub.main_page.tab_main_adapter.tab_fragments.FavoriteBar

class TabMainAdapter (
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
) : FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if(position == 0)
            AllBar()
        else
            FavoriteBar()
    }

}