package br.com.carrijo.forum.domain.repository

import br.com.carrijo.forum.domain.entity.Course
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CourseRepository : JpaRepository<Course, UUID> {
}