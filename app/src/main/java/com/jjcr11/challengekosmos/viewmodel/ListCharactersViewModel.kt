package com.jjcr11.challengekosmos.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjcr11.challengekosmos.data.ApiService
import com.jjcr11.challengekosmos.model.Page
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListCharactersViewModel @Inject constructor(
    private val apiService: ApiService
) : ViewModel() {

    private val _page = MutableLiveData<Page>()
    val page: LiveData<Page> = _page

    fun fetchPage() {
        viewModelScope.launch {
            val response = apiService.getPage("character?page=1")
            _page.value = response
        }
    }
}
