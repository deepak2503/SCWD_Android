package com.rajubista.activities

import android.os.Bundle

import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.rajubista.R
import com.rajubista.fragments.*
import com.rajubista.utills.replaceFragmenty
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)


    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_login -> {
                // Handle the camera action
                replaceFragmenty(
                        fragment = LoginFragment(),
                        allowStateLoss = true,
                        containerViewId = R.id.mainContent
                )
                setTitle("")
            }
            R.id.nav_home -> {
                replaceFragmenty(
                        fragment = HomeFragment(),
                        allowStateLoss = true,
                        containerViewId = R.id.mainContent
                )
                setTitle("")
            }

            R.id.nav_complaint -> {
                replaceFragmenty(
                        fragment = AppointmentFragment(),
                        allowStateLoss = true,
                        containerViewId = R.id.mainContent
                )
                setTitle("")
            }
            R.id.nav_appointments -> {
                replaceFragmenty(
                        fragment = NotificationFragment(),
                        allowStateLoss = true,
                        containerViewId = R.id.mainContent
                )
                setTitle("")
            }
            R.id.nav_notifications -> {
                replaceFragmenty(
                        fragment = Fragment6(),
                        allowStateLoss = true,
                        containerViewId = R.id.mainContent
                )
                setTitle("")
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
