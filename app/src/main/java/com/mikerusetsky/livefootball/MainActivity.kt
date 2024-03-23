package com.mikerusetsky.livefootball

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.mikerusetsky.livefootball.data.settings.SettingsRepository
import com.mikerusetsky.livefootball.databinding.MainActivityBinding
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
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        val navController = navHostFragment.navController
        binding.navigationView.setupWithNavController(navController)
    }
}