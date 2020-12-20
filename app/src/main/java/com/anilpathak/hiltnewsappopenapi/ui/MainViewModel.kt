package com.anilpathak.hiltnewsappopenapi.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anilpathak.hiltnewsappopenapi.model.Article
import com.anilpathak.hiltnewsappopenapi.repo.ArticleRepository
import com.anilpathak.hiltnewsappopenapi.util.DataState
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlin.coroutines.CoroutineContext

class MainViewModel
@ViewModelInject constructor(
    private val articleRepository: ArticleRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel(), CoroutineScope {

    private var parentJob = SupervisorJob()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + parentJob
    private val _dataState = MutableLiveData<DataState<List<Article>>>()

    val dataState = _dataState

    @ExperimentalCoroutinesApi
    fun setMainEvent(mainStateEvent: MainStateEvent) {
        viewModelScope.launch {
            when (mainStateEvent) {
                is MainStateEvent.ArticlePagination -> {
                        articleRepository.getArticles(mainStateEvent.page).onEach {
                            _dataState.value = it
                    }
                            .launchIn(viewModelScope)
                }
            }
        }
    }


    override fun onCleared() {
        coroutineContext.cancelChildren()
        super.onCleared()
    }
}

sealed class MainStateEvent {
    abstract class ArticlePagination(open val page: Int) : MainStateEvent()
    class GetArticlesEvent(page: Int) : ArticlePagination(page)
}