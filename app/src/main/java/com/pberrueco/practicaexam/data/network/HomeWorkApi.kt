package com.pberrueco.practicaexam.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HomeWorkApi {
    //Parsea los Json a data class
    private val converter = GsonConverterFactory.create()

    //Asigna el nivel de detalle que queremos por consola de las peticiones
    private val logginIntercerptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    //Carga el Interceptor
    private val client = OkHttpClient.Builder().addInterceptor(logginIntercerptor).build()

    //Instancia de Retrofit
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://ud5-server.onrender.com/api/v1/") // Tiene que terminar siempre en /
        .client(client)
        .addConverterFactory(converter)
        .build()
    //Para Llamar a las peticiones de red del servicio
    val service: HomeWorkService by lazy {
        retrofit.create(HomeWorkService::class.java)
    }
}