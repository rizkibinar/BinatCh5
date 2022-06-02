package id.co.rizki.binarch5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager

class ViewPagerActivity : AppCompatActivity() {

    lateinit var viewPager : ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        viewPager = findViewById(R.id.viewpager)

        viewPager.adapter = SimpleViewPagerAdapter(supportFragmentManager)


    }

    private inner class SimpleViewPagerAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm) {
        override fun getCount(): Int = 3

        override fun getItem(position: Int): Fragment = if(position == 0) FirstFragment() else SecondFragment()


    }
}