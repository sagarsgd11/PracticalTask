package com.practikaltask.presentation.main.view.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.practikaltask.databinding.ActivityMainBinding
import com.practikaltask.presentation.base.view.BaseActivity
import com.practikaltask.presentation.base.viewmodel.BaseViewModel
import com.practikaltask.presentation.main.view.adapter.PhotosAdapter
import com.practikaltask.presentation.main.viewmodel.MainViewModel
import com.practikaltask.utility.gone
import com.practikaltask.utility.visible
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    lateinit var photosAdapter: PhotosAdapter
    lateinit var binding: ActivityMainBinding
    val viewModel: MainViewModel by viewModel()

    override fun getBaseViewModel(): BaseViewModel = viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initObservers()
        initAdapter()
        initData()
    }

    fun initData() {
        binding.progressBar.visible()
        viewModel.fetchPhotosFromServer()
    }

    fun initObservers() {
        viewModel.photosResponseObserver.observe(this) {
            binding.progressBar.gone()
            photosAdapter.appendData(it)
        }
    }

    fun initAdapter() {
        photosAdapter = PhotosAdapter()
        binding.photosRecycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = photosAdapter
        }
    }
}