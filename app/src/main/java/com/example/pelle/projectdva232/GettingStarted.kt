package com.example.pelle.projectdva232

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import kotlinx.android.synthetic.main.activity_getting_started.*

class GettingStarted : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getting_started)


        val slideViewPager = findViewById<ViewPager>(R.id.slideViewPager)
        val slideAdapter = ViewPagerAdapter(supportFragmentManager)
        slideAdapter.addFragment(Page1Fragment(), 0)
        slideAdapter.addFragment(Page2Fragment(), 1)
        slideViewPager.adapter = slideAdapter
        val dots = PageDots(this, dotsLayout)
        dots.addDotsIndicator(slideAdapter.count)
        dots.setActiveDot(0)
        slideViewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

            }

            override fun onPageSelected(p0: Int) {
                dots.setActiveDot(p0)
            }

        })
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
