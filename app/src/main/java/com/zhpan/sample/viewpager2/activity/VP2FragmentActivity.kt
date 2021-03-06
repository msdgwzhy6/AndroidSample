package com.zhpan.sample.viewpager2.activity

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.integration.testapp.cards.Card
import com.google.android.material.tabs.TabLayoutMediator
import com.zhpan.sample.R
import com.zhpan.sample.viewpager2.fragment.TestFragment
import kotlinx.android.synthetic.main.activity_fragment.*

class VP2FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
//        view_pager.offscreenPageLimit=1
        view_pager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return Card.DECK.size
            }

            override fun createFragment(position: Int): Fragment {
                return TestFragment.getInstance(Card.DECK[position],position)
            }
        }

        TabLayoutMediator(tab_layout, view_pager) { tab, position ->
            tab.text = Card.DECK[position].toString()
        }.attach()
    }

}
