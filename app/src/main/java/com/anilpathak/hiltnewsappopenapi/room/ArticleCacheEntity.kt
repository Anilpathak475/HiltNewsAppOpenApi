package com.anilpathak.hiltnewsappopenapi.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class ArticleCacheEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "author")
    val author: String?,
    @ColumnInfo(name = "content")
    val content: String?,
    @ColumnInfo(name = "description")
    val description: String?,
    @ColumnInfo(name = "publishedAt")
    val publishedAt: String?,
    @ColumnInfo(name = "title")
    val title: String?,
    @ColumnInfo(name = "url")
    val url: String?,
    @ColumnInfo(name = "urlToImage")
    val urlToImage: String?
)