package br.com.carrijo.forum.api.dto.`in`

import br.com.carrijo.forum.api.dto.out.CourseView
import br.com.carrijo.forum.api.dto.out.UserView
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import java.util.UUID

data class TopicForm(

    @field:NotEmpty @field:Size(min = 5, max = 100) val title: String,
    @field:NotEmpty @field:Size(min = 5, max = 100) val message: String,
    val courseId: UUID,
    val authorId: UUID

)