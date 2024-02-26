package com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.Api

import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.model.DefaultResponse
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.model.Product

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface Api {

        @FormUrlEncoded
        @Headers("Accept: application/json")
        @POST("process-register")
        fun createUser(
            @Field("name") name:String,
            @Field("email") email:String,
            @Field("password") password:String,

        ):retrofit2.Call<DefaultResponse>

        @FormUrlEncoded
        @Headers("Accept: application/json")
        @POST("login")
        fun login(

            @Field("email") email: String,
            @Field("password") password: String
        ):retrofit2.Call<DefaultResponse>

        @GET("products")
        suspend fun getProducts(@Header("Authorization") authToken: String, @Query("hasImages") hasImages: Boolean = true): List<Product>




}