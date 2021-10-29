package com.nilmani.jobworkmanagement.repository


import com.nilmani.jobworkmanagement.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity,Long> {
}