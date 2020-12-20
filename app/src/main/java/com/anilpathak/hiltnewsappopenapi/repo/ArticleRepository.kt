package com.anilpathak.hiltnewsappopenapi.repo

import com.anilpathak.hiltnewsappopenapi.model.Article
import com.anilpathak.hiltnewsappopenapi.retrofit.ArticleRetrofit
import com.anilpathak.hiltnewsappopenapi.retrofit.NetworkMapper
import com.anilpathak.hiltnewsappopenapi.room.ArticleDao
import com.anilpathak.hiltnewsappopenapi.room.CacheMapper
import com.anilpathak.hiltnewsappopenapi.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class ArticleRepository
constructor(
    private val articleDao: ArticleDao,
    private val articleRetrofit: ArticleRetrofit,
    private val networkMapper: NetworkMapper,
    private val cacheMapper: CacheMapper
) {

    suspend fun getArticles(page:Int): Flow<DataState<List<Article>>> = flow {
        emit(DataState.Loading)
        try {
            val networkArticles  = articleRetrofit.fetchNews(page = page)
            val articles = networkMapper.mapFromEntityList(networkArticles.articles)
            articles.forEach {
                articleDao.insert(cacheMapper.mapToEntity(it))
            }
            emit(DataState.Success(cacheMapper.mapFromEntityList(articleDao.getArticles())))
        } catch (ex:Exception){
            emit(DataState.Error(ex))
        }

    }
}