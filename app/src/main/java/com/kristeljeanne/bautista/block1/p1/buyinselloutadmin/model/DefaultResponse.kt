package com.kristeljeanne.bautista.block1.p1.buyinselloutadmin.model

import com.google.gson.annotations.SerializedName

data class DefaultResponse(
    @SerializedName("error") val error: Boolean,
    @SerializedName("message") val message: String
)
