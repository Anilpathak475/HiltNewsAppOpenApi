package com.anilpathak.hiltnewsappopenapi.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ArticleCacheEntity::class], version = 1)
abstract class ArticleDatabase : RoomDatabase() {

    abstract fun articleDao() :ArticleDao

    companion object {
        const val DATABASE_NAME="article_database"
    }
}