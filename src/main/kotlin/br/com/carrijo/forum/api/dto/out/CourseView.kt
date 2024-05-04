package br.com.carrijo.forum.api.dto.out

import java.util.UUID

class CourseView(

    val id: UUID? = null,
    val name: String,
    val category: String

)