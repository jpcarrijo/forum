package br.com.carrijo.forum.api.controller

import br.com.carrijo.forum.api.dto.`in`.CourseForm
import br.com.carrijo.forum.api.dto.out.CourseView
import br.com.carrijo.forum.implementation.service.CourseService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.util.*

@Transactional
@RestController
@RequestMapping("/courses")
class CourseController(private val courseService: CourseService) {

    @GetMapping("/all")
    fun list(): List<CourseView> {
        return courseService.list()
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id: UUID): CourseView {
        return courseService.findById(id)
    }

    @PostMapping("/save")
    fun save(@RequestBody @Valid course: CourseForm): ResponseEntity<CourseView> {
        val courseView = courseService.save(course)
        val locationUri = ServletUriComponentsBuilder.fromCurrentRequest()
            .replacePath("courses/{id}")
            .buildAndExpand(courseView)
            .toUri();
        return ResponseEntity.created(locationUri).body(courseView)
    }

//    @PutMapping("/{id}")
//    fun updateTopic(
//        @PathVariable id: UUID,
//        @RequestBody @Valid form: TopicUpdateForm
//    ): ResponseEntity<TopicView> {
//        return ResponseEntity.status(HttpStatus.OK).body(topicService.updateTopic(id, form))
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    fun delete(@PathVariable id: UUID) {
//        return topicService.delete(id)
//    }
}