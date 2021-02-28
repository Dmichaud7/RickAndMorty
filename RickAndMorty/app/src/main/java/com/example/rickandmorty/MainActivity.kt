package com.example.rickandmorty

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.example.rickandmorty.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        drawerLayout = binding.drawerLayout

        val navController = this.findNavController(R.id.myNavHostFragment)

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)


    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }



//    private lateinit var  navController: NavController
//
//    private lateinit var drawerLayout: DrawerLayout
//    private lateinit var appBarConfiguration: AppBarConfiguration
//    private lateinit var navigationView: NavigationView
//
//
//    private lateinit var  listener: NavController.OnDestinationChangedListener
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//
//
//        navController = findNavController(R.id.myNavHostFragment)
//
//        drawerLayout = findViewById(R.id.drawerLayout)
//
//        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
//
//        setupActionBarWithNavController(navController, appBarConfiguration)
//
//    }
//
//
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.myNavHostFragment)
//        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
//    }
//
////    override fun onSupportNavigateUp(): Boolean {
////        val navController = this.findNavController(R.id.myNavHostFragment)
////        return NavigationUI.navigateUp(navController, drawerLayout)
////    }
//
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        getMenuInflater().inflate(R.menu.options_menu, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        val navController = findNavController(R.id.myNavHostFragment)
//        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
//    }
//
////    override fun onOptionsItemSelected(item: MenuItem): Boolean {
////        return NavigationUI.
////        onNavDestinationSelected(item,requireView().findNavController())
////                || super.onOptionsItemSelected(item)
////    }







}