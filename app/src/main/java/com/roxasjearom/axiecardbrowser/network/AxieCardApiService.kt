package com.roxasjearom.axiecardbrowser.network

import com.roxasjearom.axiecardbrowser.AxieCard
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://my-first-dissector-app.herokuapp.com"

private val interceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

private val client = OkHttpClient.Builder()
    .addInterceptor(interceptor)
    .build()

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .client(client)
    .baseUrl(BASE_URL)
    .build()

interface AxieCardApiService {
    @GET("/jeason")
    suspend fun getCards(): List<AxieCard>
}

object AxieCardsApi {
    val retrofitService: AxieCardApiService by lazy {
        retrofit.create(AxieCardApiService::class.java)
    }
}