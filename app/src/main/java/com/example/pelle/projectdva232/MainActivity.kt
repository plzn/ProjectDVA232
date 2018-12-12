package com.example.pelle.projectdva232

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

@Suppress("JAVA_CLASS_ON_COMPANION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        setTheme(if (!preferences.getBoolean("DARK_MODE", true)) {
            R.style.AppThemeLight
        } else {
            R.style.AppThemeDark
        })

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setSupportActionBar(toolbar)

        fab.setOnClickListener {
            Snackbar.make(it, "This button should show new alarm dialog", Snackbar.LENGTH_LONG).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)

        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        
        if (!preferences.getBoolean("DARK_MODE", true)) {
            menu.findItem(R.id.darkMode).title = getString(R.string.dark_mode)
            menu.findItem(R.id.darkMode).setIcon(R.drawable.ic_dark_black_24dp)
        } else {
            menu.findItem(R.id.darkMode).title = getString(R.string.light_mode)
            menu.findItem(R.id.darkMode).setIcon(R.drawable.ic_light_black_24dp)
        }

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        var preferences = PreferenceManager.getDefaultSharedPreferences(this)

        return when (item.itemId) {
            R.id.darkMode -> {
                if (item.title == getString(R.string.light_mode)) {
                    item.setIcon(R.drawable.ic_dark_black_24dp)
                    item.title = getString(R.string.dark_mode)
                    preferences.edit().putBoolean("DARK_MODE", false).apply()
                } else {
                    item.setIcon(R.drawable.ic_light_black_24dp)
                    item.title = getString(R.string.light_mode)
                    preferences.edit().putBoolean("DARK_MODE", true).apply()
                }
                finish()
                startActivity(intent)
                true
            }
            R.id.gettingStarted -> {
                true
            }
            R.id.action_settings -> {
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
