package com.example.safetyinnumbers

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu


class MainActivity : AppCompatActivity() {

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)

        toggle = ActionBarDrawerToggle(this, drawer, toolbar, 0, 0)
        drawer.addDrawerListener(toggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)

        navigationView.setNavigationItemSelectedListener { menuItem ->

            // set item as selected to persist highlight
            menuItem.isChecked = !menuItem.isChecked

            // close drawer when item is tapped
            drawer.closeDrawers()

            // Add code here to update the UI based on the item selected
            // For example, swap UI fragments here
            if (menuItem.itemId == R.id.profile) {
                Log.d("Profile", menuItem.title.toString())
            }

            true
        }

        val intent = Intent(this, MapsActivity::class.java)
        // start your next activity
        startActivity(intent)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_main_drawer, menu)
        return true
    }
}
