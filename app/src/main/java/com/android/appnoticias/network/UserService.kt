package com.android.appnoticias.network

import com.android.appnoticias.entities.User
import retrofit2.http.GET
import retrofit2.Call

interface UserService {

    @GET("users.json")
    fun getUsers(
    ): Call<List<User>>

}