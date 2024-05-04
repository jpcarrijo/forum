package br.com.carrijo.forum.api.dto.out

import java.util.UUID

class UserView(

    val id: UUID? = null,
    val name: String,
    val email: String

)