package com.anilpathak.hiltnewsappopenapi.retrofit

import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleRetrofit {
    @GET("v2/everything")
    suspend fun fetchNews(
        @Query("q") country: String = "Corona",
        @Query("from") from: String = "2020-12-20",
        @Query("sortBy") sortBy: String = "latest",
        @Query("apiKey") apiKey: String = "8e748d8db9c6466791912adc282e3bbc",
        @Query("page") page: Int = 1
    ): ArticleResponseNetworkEntity
}