package com.dev.android.paging.api

import com.dev.android.paging.models.Quote
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteApi {

    @GET("quotes")
    suspend fun getQuotes(@Query("page") page : Int) : Quote
}