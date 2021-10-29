package com.nilmani.jobworkmanagement.service

import com.nilmani.jobworkmanagement.entity.Admin
import com.nilmani.jobworkmanagement.model.request.ReqAdmin
import com.nilmani.jobworkmanagement.model.response.ResError
import com.nilmani.jobworkmanagement.repository.AdminRepository
import com.nilmani.jobworkmanagement.validation.isValid
import com.nilmani.jobworkmanagement.validation.isValidPassword
import com.nilmani.jobworkmanagement.validation.validateLetters
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import kotlin.random.Random

@Service
class AdminService {
    @Autowired
    private lateinit var adminRepository:AdminRepository

    fun addAdmin(@Validated request:ReqAdmin):Admin{
        val newAdmin =Admin(
            name = request.name,
            email = request.email,
            password = request.password,
            phoneNumber = request.phoneNumber,
            otp = Random.nextInt(11111,99999)
        )
        return adminRepository.save(newAdmin)
    }
}