package com.dev.android.paging.repositroy

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.dev.android.paging.api.QuoteApi
import com.dev.android.paging.paging.QuotePagingSource
import javax.inject.Inject


class QuoteRepository @Inject constructor(private val quoteApi: QuoteApi) {

    fun getQuote() = Pager(
        config = PagingConfig(20,100),
        pagingSourceFactory = {QuotePagingSource(quoteApi)}
    ).liveData
}