package com.example.tvshows.repository

import com.example.tvshows.api.ApiService
import javax.inject.Inject

class TvShowRepository

@Inject
constructor(private val apiService: ApiService){
    suspend fun getTvShows() = apiService.getTvShows()
}