package br.com.carrijo.forum.api.dto.`in`

import jakarta.validation.constraints.NotEmpty

data class TopicUpdateForm(

    @field:NotEmpty val title: String,
    @field:NotEmpty val message: String

)