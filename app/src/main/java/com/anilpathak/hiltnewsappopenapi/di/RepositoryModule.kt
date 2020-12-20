package com.anilpathak.hiltnewsappopenapi.di

import com.anilpathak.hiltnewsappopenapi.repo.ArticleRepository
import com.anilpathak.hiltnewsappopenapi.retrofit.ArticleRetrofit
import com.anilpathak.hiltnewsappopenapi.retrofit.NetworkMapper
import com.anilpathak.hiltnewsappopenapi.room.ArticleDao
import com.anilpathak.hiltnewsappopenapi.room.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.annotation.Signed

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

    @Signed
    @Provides
    fun provideArticleRepository(
        articleDao: ArticleDao,
        articleRetrofit: ArticleRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): ArticleRepository {
        return ArticleRepository(articleDao, articleRetrofit, networkMapper, cacheMapper)
    }
}