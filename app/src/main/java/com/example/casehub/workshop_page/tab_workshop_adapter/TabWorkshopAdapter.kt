package com.example.casehub.workshop_page.tab_workshop_adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.casehub.databinding.FragmentWorkshopBinding
import com.example.casehub.workshop_page.tab_workshop_adapter.tab_fragments.DraftsBar
import com.example.casehub.workshop_page.tab_workshop_adapter.tab_fragments.PublishedBar

class TabWorkshopAdapter (
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if(position == 0){
            PublishedBar()
        }
        else{
            DraftsBar()
        }
    }

}