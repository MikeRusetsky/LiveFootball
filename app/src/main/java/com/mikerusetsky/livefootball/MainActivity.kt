package com.mikerusetsky.livefootball

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mikerusetsky.livefootball.data.settings.SettingsRepository
import com.mikerusetsky.livefootball.databinding.MainActivityBinding
import com.mikerusetsky.livefootball.ui.Home.HomeFragment
import com.mikerusetsky.livefootball.ui.Live.LiveFragment
import com.mikerusetsky.livefootball.ui.Schedule.ScheduleFragment
import com.mikerusetsky.livefootball.ui.settings.SettingsFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    @Inject
    lateinit var settingsRepository: SettingsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
        val settings = settingsRepository.get()
        (application as App).switchTheme(settings.isDarkMode)

        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        initNavigation()
    }

    private fun initNavigation() {
        val selectedItem = binding.navigationView.selectedItemId
        when (selectedItem) {
            R.id.home -> { changeFragment(HomeFragment.newInstance(), "home") }
            R.id.settings -> { changeFragment(SettingsFragment(), "settings") }
        }

        binding.navigationView.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.home -> {
                    val tag = "home"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment(fragment ?: HomeFragment.newInstance(), tag)
                    true
                }
                R.id.live -> {
                    val tag = "live"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment(fragment ?: LiveFragment(), tag)
                    true
                }
                R.id.schedule -> {
                    val tag = "schedule"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment(fragment ?: ScheduleFragment(), tag)
                    true
                }
                R.id.settings -> {
                    val tag = "settings"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment(fragment ?: SettingsFragment(), tag)
                    true
                }

                else -> false
            }
        }
    }

    //Ищем фрагмент по тегу, если он есть то возвращаем его, если нет, то null
    private fun checkFragmentExistence(tag: String): Fragment? =
        supportFragmentManager.findFragmentByTag(tag)

   private fun changeFragment(fragment: Fragment, tag: String) {
     supportFragmentManager
        .beginTransaction()
        .replace(R.id.container, fragment, tag)
        .addToBackStack(null)
        .commit()
   }
}