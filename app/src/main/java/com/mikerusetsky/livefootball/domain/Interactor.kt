package com.mikerusetsky.livefootball.domain



import com.mikerusetsky.livefootball.MyApi
import com.mikerusetsky.livefootball.TmdbApi
import com.mikerusetsky.livefootball.data.MainRepository
import com.mikerusetsky.livefootball.data.PreferenceProvider
import com.mikerusetsky.livefootball.data.entity.TmdbResultsDto
import com.mikerusetsky.livefootball.ui.Home.HomeViewModel
import retrofit2.Converter

class Interactor (private val repo: MainRepository, private val retrofitService: TmdbApi, private val preferences: PreferenceProvider) {
    //В конструктор мы будем передавать коллбэк из вью модели, чтобы реагировать на то, когда лиги будут получены
    //и страницу, которую нужно загрузить (это для пагинации)
}