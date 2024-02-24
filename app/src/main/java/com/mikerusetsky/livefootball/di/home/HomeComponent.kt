package com.mikerusetsky.livefootball.di.home

import com.mikerusetsky.livefootball.ui.Home.HomeViewModel
import dagger.Subcomponent

@Subcomponent
interface HomeComponent {

    fun viewModel(): HomeViewModel

}