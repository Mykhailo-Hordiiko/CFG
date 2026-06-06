package com.hordiiko.cfg.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ReviewDto(
    @SerializedName("user_id")
    val userId: Long,
    val rating: Int,
    val comment: String
)