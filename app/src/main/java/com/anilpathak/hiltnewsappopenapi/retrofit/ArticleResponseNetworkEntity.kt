package com.anilpathak.hiltnewsappopenapi.retrofit


data class ArticleResponseNetworkEntity(
    val articles: List<ArticleNetworkEntity>,
    val status: String?,
    val totalResults: Int?
)