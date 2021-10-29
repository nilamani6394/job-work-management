package com.nilmani.jobworkmanagement.service

import com.nilmani.jobworkmanagement.entity.UserEntity
import com.nilmani.jobworkmanagement.model.request.ReqUser
import com.nilmani.jobworkmanagement.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {
    @Autowired
    private lateinit var userRepository: UserRepository

    fun newUser(request:ReqUser): UserEntity {
        val addUser = UserEntity(
            name = request.name
        )
        return userRepository.save(addUser)
    }
}