package com.anilpathak.hiltnewsappopenapi.model


data class Article(
    val id: Int = -1,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
)