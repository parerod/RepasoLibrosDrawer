package com.example.repasolibrosdrawer.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.repasolibrosdrawer.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        tabLayout()



        return root
    }

    fun tabLayout() {
        //Tabs Layout

        var tabs = binding.tabLa
        var viewPager2 = binding.viewPager2

        var viewPagerAdapter = ViewPagerAdapter(this)
        viewPager2.adapter = viewPagerAdapter

        TabLayoutMediator(tabs, viewPager2, (
                { tab: TabLayout.Tab?, position: Int ->
                    if (position == 0) tab?.setText("Ver Libros")
                    if (position == 1) tab?.setText("Nuevo Libro")
                })
        ).attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}