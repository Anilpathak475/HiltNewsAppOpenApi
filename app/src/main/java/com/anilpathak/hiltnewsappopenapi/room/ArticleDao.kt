package com.anilpathak.hiltnewsappopenapi.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(articleCacheEntity: ArticleCacheEntity): Long

    @Query("Select * from articles")
    suspend fun getArticles(): List<ArticleCacheEntity>
}