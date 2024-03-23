package com.mikerusetsky.livefootball.ui.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.memorycards.Base.Factory
import com.mikerusetsky.livefootball.App
import com.mikerusetsky.livefootball.R
import com.mikerusetsky.livefootball.databinding.FragmentSettingsBinding
import kotlinx.coroutines.launch

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private val binding by viewBinding(FragmentSettingsBinding::bind)
    private val viewModel by viewModels<SettingsViewModel> {
        Factory {
            App.appComponent.settingsComponent().viewModel()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.darkMode.setOnClickListener {
            val darkMode = binding.darkMode.isChecked
            viewModel.darkModeChanged(darkMode)
            (requireActivity().application as App).switchTheme(darkMode)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.observeUi().collect { state ->
                    binding.darkMode.isChecked = state.settings?.isDarkMode ?: false
                }
            }
        }
    }

}