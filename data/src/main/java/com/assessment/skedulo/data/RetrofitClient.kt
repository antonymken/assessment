package com.assessment.skedulo.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


abstract class RetrofitClient {

    protected inline fun <reified T>createApiClient(): T {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        return retrofit.create(T::class.java)
    }

}