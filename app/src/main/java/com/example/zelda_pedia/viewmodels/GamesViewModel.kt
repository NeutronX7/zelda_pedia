package com.example.zelda_pedia.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zelda_pedia.Repository
import com.example.zelda_pedia.models.games.Game
import com.example.zelda_pedia.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _mutableLiveData = MutableLiveData<Resource<Response<Game>>>()
    val mutableLiveData: LiveData<Resource<Response<Game>>> = _mutableLiveData

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage = _errorMessage

    private val _isLoading = MutableLiveData(true)
    val isLoading = _isLoading
    fun getGames() = viewModelScope.launch(Dispatchers.IO) {

        val result = repository.getGames()

        when (result) {
            is Resource.Success -> {
                _mutableLiveData.postValue(result)
                _isLoading.postValue(false)
            }
            is Resource.Error -> {
                _isLoading.postValue(false)
                _errorMessage.postValue(result.data?.message().toString())
            }
            else -> {
                _isLoading.postValue(true)
            }
        }
    }

}