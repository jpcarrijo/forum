package br.com.carrijo.forum.implementation.service

import br.com.carrijo.forum.api.converter.MapperUser
import br.com.carrijo.forum.api.dto.`in`.UserForm
import br.com.carrijo.forum.api.dto.out.UserView
import br.com.carrijo.forum.domain.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private var userRepository: UserRepository,
    private var mapperUser: MapperUser
) {

    fun list(): List<UserView> {
        return mapperUser.entityListToViewList(userRepository.findAll())
    }

    fun findById(id: UUID): UserView {
        return mapperUser.entityToView(userRepository.findById(id).get())
    }

    fun save(userForm: UserForm): UserView {
        val userSave = mapperUser.formToEntity(userForm)

        userRepository.save(userSave)
        return mapperUser.entityToView(userSave)
    }
}
