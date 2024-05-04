package br.com.carrijo.forum.api.dto.out

import br.com.carrijo.forum.domain.StatusTopic
import java.time.LocalDateTime
import java.util.*

data class TopicView(

    val id: UUID? = null,
    val title: String,
    val message: String,
    val statusTopic: StatusTopic,
    val createDate: LocalDateTime

)