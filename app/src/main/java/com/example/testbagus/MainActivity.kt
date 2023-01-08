package com.example.testbagus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.testbagus.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter =myviewpageradapter(supportFragmentManager)
        adapter.addFragment(FibonaciFragment(),"FIBONACCI")
        adapter.addFragment(KeluargaFragment(),"FAMILY")
        binding.myviewpager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.myviewpager)



//        initdata()
        val search = ""
//        initsearchparent("A005")


//        Log.d("isielement", "onCreate: " + listorang2.toString())
    }



    class myviewpageradapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

       private val Fragmentlist : MutableList<Fragment> =ArrayList()
       private val TitleList : MutableList<String> =ArrayList()


        override fun getCount(): Int {
            return Fragmentlist.size
        }

        override fun getItem(position: Int): Fragment {
            return Fragmentlist[position]
        }
        fun addFragment(fragment:Fragment, title:String){
                Fragmentlist.add(fragment)
                TitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return TitleList[position]
        }
    }


}
class myviewpageradapter(fm:FragmentManager):FragmentPagerAdapter(fm) {

    private val Fragmentlist : MutableList<Fragment> =ArrayList()
    private val TitleList : MutableList<String> =ArrayList()


    override fun getCount(): Int {
        return Fragmentlist.size
    }

    override fun getItem(position: Int): Fragment {
        return Fragmentlist[position]
    }
    fun addFragment(fragment:Fragment, title:String){
        Fragmentlist.add(fragment)
        TitleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return TitleList[position]
    }


}