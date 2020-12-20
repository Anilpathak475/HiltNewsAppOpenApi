package com.anilpathak.hiltnewsappopenapi.retrofit

import com.anilpathak.hiltnewsappopenapi.model.Article
import com.anilpathak.hiltnewsappopenapi.util.EntityMapper
import javax.inject.Inject

class NetworkMapper
@Inject constructor() : EntityMapper<ArticleNetworkEntity, Article> {
    override fun mapFromEntity(entity: ArticleNetworkEntity): Article {
        return Article(
            author = entity.author,
            content = entity.content,
            description = entity.description,
            publishedAt = entity.publishedAt,
            title = entity.title,
            url = entity.url,
            urlToImage = entity.urlToImage
        )
    }

    override fun mapToEntity(domainModel: Article): ArticleNetworkEntity {
        return ArticleNetworkEntity(
            author = domainModel.author,
            content = domainModel.content,
            description = domainModel.description,
            publishedAt = domainModel.publishedAt,
            title = domainModel.title,
            url = domainModel.url,
            urlToImage = domainModel.urlToImage
        )
    }

    fun mapFromEntityList(entities: List<ArticleNetworkEntity>): List<Article> {
        return entities.map { mapFromEntity(it) }
    }
}