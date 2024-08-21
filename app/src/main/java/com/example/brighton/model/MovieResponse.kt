package com.example.brighton.model

data class MovieResponse(
    val Search: List<Movie>,
    val totalResults: String,
    val Response: String
)