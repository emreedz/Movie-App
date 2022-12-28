package com.example.mymoviemvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mymoviemvvm.Fragment.BestFragment
import com.example.mymoviemvvm.Fragment.FavoriteFragment
import com.example.mymoviemvvm.Fragment.NewFragment
import com.example.mymoviemvvm.Fragment.PopularFragment
import com.example.mymoviemvvm.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(BestFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.best_Movie -> replaceFragment(BestFragment())
                R.id.new_Movie -> replaceFragment(NewFragment())
                R.id.populer_Movie -> replaceFragment(PopularFragment())
                R.id.favorite_Movie -> replaceFragment(FavoriteFragment())
                else -> {

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}