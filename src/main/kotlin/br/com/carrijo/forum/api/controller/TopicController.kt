package br.com.carrijo.forum.api.controller

import br.com.carrijo.forum.api.dto.`in`.TopicForm
import br.com.carrijo.forum.api.dto.`in`.TopicUpdateForm
import br.com.carrijo.forum.api.dto.out.TopicView
import br.com.carrijo.forum.implementation.service.TopicService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.util.*

@Transactional
@RestController
@RequestMapping("/topics")
class TopicController(private val topicService: TopicService) {

    @GetMapping("/all")
    fun list(@RequestParam(value = "name-course", required = false) nameCourse: String?): List<TopicView> {
        return topicService.list(nameCourse)
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id: UUID): TopicView {
        return topicService.findById(id)
    }

    @PostMapping("/save")
    fun save(@RequestBody @Valid topic: TopicForm): ResponseEntity<TopicView> {
        val topicView = topicService.save(topic)
        val locationUri = ServletUriComponentsBuilder.fromCurrentRequest()
            .replacePath("topics/{id}")
            .buildAndExpand(topicView)
            .toUri();
        return ResponseEntity.created(locationUri).body(topicView)
    }

    @PutMapping("/{id}")
    fun updateTopic(
        @PathVariable id: UUID,
        @RequestBody @Valid form: TopicUpdateForm
    ): ResponseEntity<TopicView> {
        return ResponseEntity.status(HttpStatus.OK).body(topicService.updateTopic(id, form))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: UUID) {
        return topicService.delete(id)
    }
}