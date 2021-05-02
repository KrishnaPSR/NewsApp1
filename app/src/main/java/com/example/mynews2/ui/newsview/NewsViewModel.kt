package com.example.mynews2.ui.newsview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewsViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is NewsView Fragment"
    }
    val text: LiveData<String> = _text
}

/*
use apply for code blocks that don't return a value and mainly operate on the members of the receiver object.
The common case for apply is the object configuration.
 */