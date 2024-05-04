package br.com.carrijo.forum.infra.exception.details

import java.util.Date
import java.util.LinkedHashSet

data class ExceptionSetDetails(

    val title: String,
    val status: Int,
    val timestamp: Date,
    val path: String,
    val errorSet: LinkedHashSet<Errors>

)

data class Errors(

    var field: String = "",
    var message: String = "",

)