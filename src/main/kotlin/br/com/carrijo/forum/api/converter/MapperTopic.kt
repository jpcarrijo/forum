package br.com.carrijo.forum.api.converter

import br.com.carrijo.forum.api.converter.`interface`.Mapper
import br.com.carrijo.forum.api.dto.`in`.TopicForm
import br.com.carrijo.forum.api.dto.out.TopicView
import br.com.carrijo.forum.domain.entity.Topic
import br.com.carrijo.forum.domain.repository.CourseRepository
import br.com.carrijo.forum.domain.repository.UserRepository
import org.springframework.context.annotation.Configuration
import java.util.stream.Collectors

@Configuration
class MapperTopic(
    private val courseRepository: CourseRepository,
    private val userRepository: UserRepository
) : Mapper<Topic, TopicForm, TopicView> {
    override fun formToEntity(f: TopicForm): Topic {
        val course = courseRepository.findById(f.courseId).get()
        val author = userRepository.findById(f.authorId).get()
        return Topic(
            title = f.title,
            message = f.message,
            course = course,
            author = author
        )
    }

    override fun entityToView(e: Topic): TopicView {
        return TopicView(
            e.id,
            e.title,
            e.message,
            e.status,
            e.createDate
        )
    }

    override fun entityListToViewList(eList: List<Topic>): List<TopicView> {
        return eList.stream().map { e ->
            TopicView(
                id = e.id,
                title = e.title,
                message = e.message,
                statusTopic = e.status,
                createDate = e.createDate
            )
        }.collect(Collectors.toList())
    }
}
