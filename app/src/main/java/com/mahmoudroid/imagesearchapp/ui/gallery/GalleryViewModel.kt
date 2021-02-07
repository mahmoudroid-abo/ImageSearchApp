package com.mahmoudroid.imagesearchapp.ui.gallery

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.mahmoudroid.imagesearchapp.data.UnSplashRepository

class GalleryViewModel @ViewModelInject constructor
    (private val repository: UnSplashRepository, @Assisted state: SavedStateHandle) : ViewModel() {

    //    private val currentQuery = MutableLiveData(DEFAULT_QUERY)
    private val currentQuery = state.getLiveData(CURRENT_QUERY, DEFAULT_QUERY)

    val photos = currentQuery.switchMap { queryString ->
        repository.getSearchResults(queryString).cachedIn(viewModelScope)
    }

    fun searchPhotos(query: String) {
        currentQuery.value = query
    }

    companion object {
        private const val CURRENT_QUERY = "current_query"
        private const val DEFAULT_QUERY = "dog"
    }
}