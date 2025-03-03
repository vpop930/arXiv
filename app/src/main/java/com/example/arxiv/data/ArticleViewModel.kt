package com.example.arxiv.data

import androidx.lifecycle.ViewModel

class ArticleViewModel(
    private val dao: ArticleDAO
) : ViewModel() {
    var state by mutableStateOf(ArticleState())
        private set


}