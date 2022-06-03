package com.example.tvshows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tvshows.adapter.TvShowAdapter
import com.example.tvshows.databinding.ActivityMainBinding
import com.example.tvshows.viewmodel.TvShowViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val tvShowViewModel: TvShowViewModel by viewModels()
    private lateinit var tvShowAdapter : TvShowAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        setUpRv()
    }

    private fun setUpRv(){
        tvShowAdapter = TvShowAdapter()

        binding.recyclerView.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }

        binding.rvEpisodes.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }

        binding.rvRecentlyAdded.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }

        tvShowViewModel.responseTvShow.observe(this) { listTvShow ->
            tvShowAdapter.tvShowsResponseItem = listTvShow
        }

    }
}