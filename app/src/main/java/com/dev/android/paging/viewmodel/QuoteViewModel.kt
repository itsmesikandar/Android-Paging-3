package com.dev.android.paging.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.dev.android.paging.repositroy.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(private val quoteRepository: QuoteRepository) : ViewModel() {

    val quotesLiveData = quoteRepository.getQuote().cachedIn(viewModelScope)
}