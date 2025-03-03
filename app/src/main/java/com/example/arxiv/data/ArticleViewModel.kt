package com.example.arxiv.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf

class ArticleViewModel(
    private val dao: ArticleDAO
) : ViewModel() {
    var state by mutableStateOf(ArticleState())
        private set

    init {
        viewModelScope.launch {
            dao.getArticles().collectLatest {
                state = state.copy(
                    products = it
                )
            }
        }
    }

    fun changeName(name: String) {
        state = state.copy(
            articleName = name
        )
    }

    fun changeCategory(category: String) {
        state = state.copy(
            articleCategory = category
        )
    }
}