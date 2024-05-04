package br.com.carrijo.forum.api.converter

import br.com.carrijo.forum.api.converter.`interface`.Mapper
import br.com.carrijo.forum.api.dto.`in`.UserForm
import br.com.carrijo.forum.api.dto.out.UserView
import br.com.carrijo.forum.domain.entity.User
import org.springframework.context.annotation.Configuration
import java.util.stream.Collectors

@Configuration
class MapperUser : Mapper<User, UserForm, UserView> {
    override fun formToEntity(f: UserForm): User {
        return User(
            name = f.name,
            email = f.email
        )
    }

    override fun entityToView(e: User): UserView {
        return UserView(
            e.id,
            e.name,
            e.email
        )
    }

    override fun entityListToViewList(eList: List<User>): List<UserView> {
        return eList.stream().map { e ->
            UserView(
                id = e.id,
                name = e.name,
                email = e.email
            )
        }.collect(Collectors.toList())
    }
}
