package com.jjcr11.challengekosmos.data

import com.jjcr11.challengekosmos.model.Page
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    suspend fun getPage(@Url url: String): Page
}