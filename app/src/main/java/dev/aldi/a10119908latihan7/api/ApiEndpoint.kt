package dev.aldi.a10119908latihan7.api

import dev.aldi.a10119908latihan7.SwapiResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {
    @GET("people")
    fun getPeople(): Call<SwapiResponse>
}