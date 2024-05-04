package br.com.carrijo.forum.domain.entity

import br.com.carrijo.forum.domain.StatusTopic
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "tb_topic")
data class Topic(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID? = null,
    var title: String,
    var message: String,
    val createDate: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    val course: Course,
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    val author: User,
    @Enumerated(value = EnumType.STRING)
    val status: StatusTopic = StatusTopic.NOT_ANSWERED,
    @OneToMany(mappedBy = "topic")
    val answers: List<Answers> = ArrayList()

)