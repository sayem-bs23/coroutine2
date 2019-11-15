package com.bs.corooutine2


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService{

//    @GET("placeholder/user/{userId}")
//    suspend fun getUser(
//        @Path("userId") userId:String
//    ):User

//@GET("data/2.5/forecast/?")
//fun getUser(               @Query("lat") lat: String,
//                           @Query("lon") lon: String,
//                           @Query("APPID") app_id: String,
//                           @Query("units") units: String
//
//): Call<User>

    @GET("data/2.5/forecast/?")
    suspend fun getUser(       @Query("lat") lat: String,
                               @Query("lon") lon: String,
                               @Query("APPID") app_id: String,
                               @Query("units") units: String

    ): User


}