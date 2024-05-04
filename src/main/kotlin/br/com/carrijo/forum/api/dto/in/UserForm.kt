package br.com.carrijo.forum.api.dto.`in`

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class UserForm(

    @field:NotEmpty val name: String,
    @field:Email val email: String

)
