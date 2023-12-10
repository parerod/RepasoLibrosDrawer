package com.example.repasolibrosdrawer.ui.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.repasolibrosdrawer.fragments.nuevoLibro_Fragment
import com.example.repasolibrosdrawer.fragments.verLibro_Fragment

class ViewPagerAdapter(fragment: HomeFragment) : FragmentStateAdapter(fragment) {

    val list: List<Fragment> = listOf(verLibro_Fragment(),nuevoLibro_Fragment())

    override fun getItemCount(): Int = list.size

    override fun createFragment(position: Int): Fragment {
        return list.get(position)
    }

}