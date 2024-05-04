package br.com.carrijo.forum.implementation.service

import br.com.carrijo.forum.api.converter.MapperCourse
import br.com.carrijo.forum.api.dto.`in`.CourseForm
import br.com.carrijo.forum.api.dto.out.CourseView
import br.com.carrijo.forum.domain.repository.CourseRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseService(
    private var courseRepository: CourseRepository,
    private val mapperCourse: MapperCourse
) {

    fun list(): List<CourseView> {
        return mapperCourse.entityListToViewList(courseRepository.findAll())
    }

    fun findById(id: UUID): CourseView {
        return mapperCourse.entityToView(courseRepository.findById(id).get())
    }

    fun save(courseForm: CourseForm): CourseView {
        val courseSave = mapperCourse.formToEntity(courseForm)

        courseRepository.save(courseSave)
        return mapperCourse.entityToView(courseSave)
    }
}
