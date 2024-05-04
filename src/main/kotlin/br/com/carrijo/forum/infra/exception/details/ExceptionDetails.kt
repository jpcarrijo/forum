package br.com.carrijo.forum.infra.exception.details

import java.util.*

data class ExceptionDetails(

    val title: String,
    val status: Int,
    val timestamp: Date,
    val path: String,
    val message: String?

)