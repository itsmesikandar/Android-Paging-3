package com.dev.android.paging.module

import com.dev.android.paging.utils.Constants
import com.dev.android.paging.api.QuoteApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {


    @Singleton
    @Provides
    fun getProvides() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Singleton
    @Provides
    fun getQuoteApi(retrofit: Retrofit) : QuoteApi {
        return  retrofit.create(QuoteApi::class.java)
    }
}