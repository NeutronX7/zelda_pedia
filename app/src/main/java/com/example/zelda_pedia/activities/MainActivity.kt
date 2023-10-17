package com.example.zelda_pedia.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.example.zelda_pedia.adapters.GameAdapter
import com.example.zelda_pedia.databinding.ActivityMainBinding
import com.example.zelda_pedia.viewmodels.GamesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<GamesViewModel>()
    private val adapter by lazy {
        GameAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel.getGames()

        viewModel.isLoading.observe(this) {
            if(it == true) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.INVISIBLE
                getData()
                setupList()
            }
        }
    }

    private fun setupList() {
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.itemAnimator = DefaultItemAnimator()
        binding.recyclerView.adapter = adapter
    }

    private fun getData() {
        viewModel.mutableLiveData.observe(this) {
            adapter.addList(it.data?.body()!!.data)
        }
    }
}