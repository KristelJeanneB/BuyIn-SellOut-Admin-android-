package com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.Api

import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.model.DefaultResponse
import com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.model.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

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
            @Field("user_id") studentID: String,
            @Field("email") email: String,
            @Field("password") password: String
        ):retrofit2.Call<DefaultResponse>


}