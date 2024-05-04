package br.com.carrijo.forum.domain.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "tb_course")
data class Course(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID? = null,
    val name: String,
    val category: String

)
