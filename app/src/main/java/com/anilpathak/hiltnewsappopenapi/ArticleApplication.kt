package com.anilpathak.hiltnewsappopenapi

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ArticleApplication:Application() {
    override fun onCreate() {
        super.onCreate()
    }
}