package com.mikerusetsky.livefootball.di.settings

import com.mikerusetsky.livefootball.ui.settings.SettingsViewModel
import dagger.Subcomponent

@Subcomponent
interface SettingsComponent {

    fun viewModel(): SettingsViewModel

}