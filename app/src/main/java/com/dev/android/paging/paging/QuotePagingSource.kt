package com.dev.android.paging.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dev.android.paging.api.QuoteApi
import com.dev.android.paging.models.Result
import com.dev.android.paging.utils.Constants.TAG

class QuotePagingSource (private val quoteApi: QuoteApi) : PagingSource<Int,Result>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try{
            val position = params.key ?: 1
            val response = quoteApi.getQuotes(position)
            Log.d(TAG, "Total page: ${response.totalPages}")
            LoadResult.Page(
                data = response.results,
                prevKey = if(position == 1) null else position - 1,
                nextKey = if(position == response.totalPages) null else position + 1
            )
        }catch (e : Exception) {
            Log.d(TAG, "load: Error $e")
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

}