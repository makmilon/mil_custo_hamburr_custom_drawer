package com.milon.customehamburg

import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.milon.customehamburg.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding


  private  lateinit var navController: NavController
  private lateinit var navHostFragment: NavHostFragment
  private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.toolbar)

       actionBarDrawerToggle= ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.open, R.string.close)


        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController


        binding.navView.setNavigationItemSelectedListener { menuItem ->

            when (menuItem.itemId) {
                R.id.homeFragment -> {
                    // Handle click on menu item 1
                    navController.navigate(R.id.homeFragment)
                    binding.drawerLayout.closeDrawer(GravityCompat.START)

                    true
                }
                R.id.daFragment -> {
                    // Handle click on menu item 2
                    navController.navigate(R.id.daFragment)
                    binding.drawerLayout.closeDrawer(GravityCompat.START)

                    true
                }
                R.id.logout -> {
                    // Handle click on menu item 2
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                     Toast.makeText(applicationContext, "This is Logout", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }



    }


}