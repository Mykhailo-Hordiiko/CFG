package com.hordiiko.cfg.domain.model

data class Review(
    val userId: Long,
    val rating: Int,
    val comment: String
)