package br.com.carrijo.forum.api.converter

import br.com.carrijo.forum.api.converter.`interface`.Mapper
import br.com.carrijo.forum.api.dto.`in`.CourseForm
import br.com.carrijo.forum.api.dto.out.CourseView
import br.com.carrijo.forum.domain.entity.Course
import org.springframework.context.annotation.Configuration
import java.util.stream.Collectors

@Configuration
class MapperCourse : Mapper<Course, CourseForm, CourseView> {
    override fun formToEntity(f: CourseForm): Course {
        return Course(
            name = f.name,
            category = f.category
        )
    }

    override fun entityToView(e: Course): CourseView {
        return CourseView(
            e.id,
            e.name,
            e.category
        )
    }

    override fun entityListToViewList(eList: List<Course>): List<CourseView> {
        return eList.stream().map { e ->
            CourseView(
                id = e.id,
                name = e.name,
                category = e.category
            )
        }.collect(Collectors.toList())
    }

}
