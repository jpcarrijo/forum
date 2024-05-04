package br.com.carrijo.forum.domain.entity

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "tb_answers")
data class Answers(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID,
    val message: String,
    val createDate: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val author: User,
    @ManyToOne
    val topic: Topic,
    val solution: Short

)
