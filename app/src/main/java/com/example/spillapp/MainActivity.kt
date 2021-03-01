package com.example.spillapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.example.spillapp.databinding.ActivityMainBinding
import com.example.spillapp.fragments.HomeFragment
import com.example.spillapp.fragments.NotificationFragment
import com.example.spillapp.fragments.SettingsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val homeFragment = HomeFragment()
        val notificationFragment = NotificationFragment ()
        val settingsFragment = SettingsFragment()

        makeCurrentFragment(homeFragment)

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.ic_home -> makeCurrentFragment(homeFragment)
                R.id.ic_fave -> makeCurrentFragment(settingsFragment)
                R.id.ic_notif ->makeCurrentFragment(notificationFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}