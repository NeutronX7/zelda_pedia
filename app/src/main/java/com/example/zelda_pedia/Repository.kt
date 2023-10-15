package com.example.zelda_pedia

import com.example.zelda_pedia.io.API
import com.example.zelda_pedia.models.games.Game
import com.example.zelda_pedia.utils.Resource
import dagger.hilt.android.scopes.ActivityScoped
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped
class Repository @Inject constructor(
    private val api: API
) {

    suspend fun getGames(): Resource<Response<Game>> {
        val response = try {
            api.getGames()
        } catch (e: Exception) {
            return Resource.Error("Error: $e")
        }

        return Resource.Success(response)
    }

}