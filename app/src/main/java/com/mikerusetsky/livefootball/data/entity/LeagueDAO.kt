package com.mikerusetsky.livefootball.data.entity

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mikerusetsky.livefootball.domain.League


@Dao
interface LeagueDAO {
    //Запрос на всю таблицу
    @Query("SELECT * FROM cached_league")
    fun getCachedFilms(): List<League>

    //Кладём списком в БД, в случае конфликта перезаписываем
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<League>)
}