package com.moapps.advicebestfriend.pojo

data class SearchAdvice(
    val query: String,
    val slips: List<SlipX>,
    val total_results: String
)