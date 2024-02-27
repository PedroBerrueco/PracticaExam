package com.pberrueco.practicaexam.data.network

import com.pberrueco.practicaexam.data.network.model.HomeWorkResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface HomeWorkService {

    @GET("homeWork/{school}")
    suspend fun getHomeWork(@Header("Authorization") userName: String, @Path("school")school: String) : Response<List<HomeWorkResponse>>
}