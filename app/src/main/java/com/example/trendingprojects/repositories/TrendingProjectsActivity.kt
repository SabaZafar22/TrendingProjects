package com.example.trendingprojects.repositories

import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.example.trendingprojects.R
import com.example.trendingprojects.databinding.ActivityTrendingProjectsBinding
import com.example.trendingprojects.repositories.ui.TrendingProjectsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrendingProjectsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrendingProjectsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_trending_projects)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    private fun changeMode() {
        val mode =
            if ((resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) ==
                Configuration.UI_MODE_NIGHT_NO
            ) {
                AppCompatDelegate.MODE_NIGHT_YES
            } else {
                AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY
            }

        // Change UI Mode
        AppCompatDelegate.setDefaultNightMode(mode)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_refresh -> {
                refresh()
                true
            }
            R.id.action_day_night_mode -> {
                changeMode()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun refresh() {
        val navHostFragment = supportFragmentManager.primaryNavigationFragment

        val fragment = navHostFragment?.childFragmentManager?.fragments?.get(0)

        if (fragment is TrendingProjectsFragment) {
            fragment.refresh()
        }
    }
}