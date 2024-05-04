package br.com.carrijo.forum.api.dto.`in`

import jakarta.validation.constraints.NotEmpty

data class CourseForm(

    @field:NotEmpty val name: String,
    @field:NotEmpty val category: String

)
