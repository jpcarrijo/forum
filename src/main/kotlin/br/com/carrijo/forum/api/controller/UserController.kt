package br.com.carrijo.forum.api.controller

import br.com.carrijo.forum.api.dto.`in`.UserForm
import br.com.carrijo.forum.api.dto.out.UserView
import br.com.carrijo.forum.implementation.service.UserService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.util.*

@Transactional
@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

    @GetMapping("/all")
    fun list(): List<UserView> {
        return userService.list()
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id: UUID): UserView {
        return userService.findById(id)
    }

    @PostMapping("/save")
    fun save(@RequestBody @Valid user: UserForm): ResponseEntity<UserView> {
        val userView = userService.save(user)
        val locationUri = ServletUriComponentsBuilder.fromCurrentRequest()
            .replacePath("users/{id}")
            .buildAndExpand(userView)
            .toUri();
        return ResponseEntity.created(locationUri).body(userView)
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