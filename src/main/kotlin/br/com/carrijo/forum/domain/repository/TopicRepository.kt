package br.com.carrijo.forum.domain.repository

import br.com.carrijo.forum.api.dto.out.TopicView
import br.com.carrijo.forum.domain.entity.Topic
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TopicRepository: JpaRepository<Topic, UUID> {

    fun findAllByCourseName(nameCourse: String?): List<Topic>
}