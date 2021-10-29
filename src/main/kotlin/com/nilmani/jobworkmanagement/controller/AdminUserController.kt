package com.nilmani.jobworkmanagement.controller

import com.nilmani.jobworkmanagement.model.request.ReqUser
import com.nilmani.jobworkmanagement.model.response.RespUser
import com.nilmani.jobworkmanagement.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin")
class AdminUserController {
    @Autowired
    private lateinit var  userService: UserService
    @PostMapping("/signupUser")
    fun signUpUser(@ModelAttribute request:ReqUser):ResponseEntity<*>{
        val newUser = userService.newUser(request)
        val respUser = RespUser(
            newUser.name
        )
        return ResponseEntity(respUser,HttpStatus.OK)
    }
}