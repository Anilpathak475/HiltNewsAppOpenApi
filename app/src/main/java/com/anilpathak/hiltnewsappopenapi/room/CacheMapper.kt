package com.anilpathak.hiltnewsappopenapi.room

import com.anilpathak.hiltnewsappopenapi.model.Article
import com.anilpathak.hiltnewsappopenapi.util.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject constructor() : EntityMapper<ArticleCacheEntity, Article> {
    override fun mapFromEntity(entity: ArticleCacheEntity): Article {
        return Article(
            id = entity.id,
            author = entity.author,
            content = entity.content,
            description = entity.description,
            publishedAt = entity.publishedAt,
            title = entity.title,
            url = entity.url,
            urlToImage = entity.urlToImage
        )
    }

    override fun mapToEntity(domainModel: Article): ArticleCacheEntity {
        return ArticleCacheEntity(
            id = domainModel.id,
            author = domainModel.author,
            content = domainModel.content,
            description = domainModel.description,
            publishedAt = domainModel.publishedAt,
            title = domainModel.title,
            url = domainModel.url,
            urlToImage = domainModel.urlToImage
        )
    }

    fun mapFromEntityList(entities: List<ArticleCacheEntity>): List<Article> {
        return entities.map { mapFromEntity(it) }
    }

}