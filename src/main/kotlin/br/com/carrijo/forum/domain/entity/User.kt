package br.com.carrijo.forum.domain.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "tb_user")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID? = null,
    val name: String,
    val email: String

)
