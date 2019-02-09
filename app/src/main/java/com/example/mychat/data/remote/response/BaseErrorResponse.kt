package com.example.mychat.data.remote.response

import com.google.gson.annotations.SerializedName

class BaseErrorResponse(
    @SerializedName("code") var code: String? = null,
    @SerializedName("message") val message: String? = null,
    @SerializedName("errors") val errors: Error? = null
)
