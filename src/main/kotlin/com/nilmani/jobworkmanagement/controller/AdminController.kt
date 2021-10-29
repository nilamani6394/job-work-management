package com.nilmani.jobworkmanagement.controller

import com.nilmani.jobworkmanagement.model.request.ReqAdmin
import com.nilmani.jobworkmanagement.model.response.ResError
import com.nilmani.jobworkmanagement.model.response.ResMessage
import com.nilmani.jobworkmanagement.model.response.RespAdmin
import com.nilmani.jobworkmanagement.service.AdminService
import com.nilmani.jobworkmanagement.validation.isValid
import com.nilmani.jobworkmanagement.validation.isValidPassword
import com.nilmani.jobworkmanagement.validation.validateLetters
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin")
class AdminController {
    @Autowired
    private lateinit var adminService: AdminService

    @PostMapping("/signUp")
    fun signUp(@ModelAttribute request:ReqAdmin):ResponseEntity<*>{
        val map=HashMap<String,String>()
        if (request.name.validateLetters()){
            map["name"]="Name cannot be empty, name contain only letter"
        }
        if (request.email.isValid()){
            map["email"] = "enter a valid email"
        }
        if (request.password.isValidPassword()){
            map["password"] = "Password must contain UpperCase,LowerCase,Digit,Special char,and pass word length 8 char"
        }
        if (map.isNullOrEmpty()){
            return ResponseEntity(ResError(map),HttpStatus.BAD_REQUEST)
        }
        val newAdmin = adminService.addAdmin(request)
        val respAdmin = RespAdmin(
            newAdmin.name,
            newAdmin.email,
            newAdmin.phoneNumber,
        )
        return ResponseEntity(respAdmin,HttpStatus.OK)
    }
}