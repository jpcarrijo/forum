package br.com.carrijo.forum.implementation.service

import br.com.carrijo.forum.api.converter.MapperTopic
import br.com.carrijo.forum.api.dto.`in`.TopicForm
import br.com.carrijo.forum.api.dto.`in`.TopicUpdateForm
import br.com.carrijo.forum.api.dto.out.TopicView
import br.com.carrijo.forum.domain.repository.TopicRepository
import br.com.carrijo.forum.infra.exception.NotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicService(
    private var topicRepository: TopicRepository,
    private var mapper: MapperTopic,
) {

    companion object {
        const val NOTFOUND = "Tópico Não Encontrado!!!"
    }

    fun list(nameCourse: String?): List<TopicView> {
        val listTopic = if (nameCourse == null) {
            mapper.entityListToViewList(topicRepository.findAll())
        } else {
            mapper.entityListToViewList(topicRepository.findAllByCourseName(nameCourse))
        }
        return listTopic
    }

    fun findById(id: UUID): TopicView {
        val topic = topicRepository.findById(id).orElseThrow { NotFoundException(NOTFOUND) }
        return mapper.entityToView(topic)
    }

    fun save(topic: TopicForm): TopicView {
        var topicSave = mapper.formToEntity(topic)

        topicSave = topicRepository.save(topicSave)
        println(topicSave)
        return mapper.entityToView(topicSave)
    }

    fun updateTopic(id: UUID, form: TopicUpdateForm): TopicView {
        val topic = topicRepository.findById(id).orElseThrow { NotFoundException(NOTFOUND) }
        topic.title = form.title
        topic.message = form.message

        return mapper.entityToView(topic)
    }

    fun delete(id: UUID) {
        try {
            topicRepository.deleteById(id)
        } catch (e: RuntimeException) {
            throw NotFoundException(NOTFOUND)
        }
    }
}