package com.mikerusetsky.livefootball.domain

import com.mikerusetsky.livefootball.TmdbApi
import com.mikerusetsky.livefootball.data.MainRepository
import com.mikerusetsky.livefootball.data.PreferenceProvider

class Interactor (private val repo: MainRepository, private val retrofitService: TmdbApi,
                  private val preferences: PreferenceProvider) {

}