package com.dev.android.paging.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dev.android.paging.R
import com.dev.android.paging.adapter.QuotePagerAdapter
import com.dev.android.paging.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var adapter : QuotePagerAdapter
    private lateinit var quoteViewModel : QuoteViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.quoteList)
        quoteViewModel = ViewModelProvider(this)[QuoteViewModel::class.java]
        adapter = QuotePagerAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        bindObserver()

    }

    private fun bindObserver() {
        quoteViewModel.quotesLiveData.observe(this) {
            if (it != null) {
                adapter.submitData(lifecycle, it)

            }
        }
    }
}