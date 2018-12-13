package com.example.pelle.projectdva232

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager

class GettingStarted : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getting_started)


        val slideViewPager = findViewById<ViewPager>(R.id.slideViewPager)
        val slideAdapter = ViewPagerAdapter(supportFragmentManager)
        slideAdapter.addFragment(Page1Fragment(), 0)
        slideAdapter.addFragment(Page2Fragment(), 1)
        slideViewPager.adapter = slideAdapter


    }

    class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager)
    {
        private val fragmentList = HashMap<Int, Fragment>()


        override fun getItem(pO: Int): Fragment {
            return fragmentList.getValue(pO)
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        fun addFragment(fragment: Fragment, position:Int)
        {
            fragmentList.put(position, fragment)

        }




    }
}
