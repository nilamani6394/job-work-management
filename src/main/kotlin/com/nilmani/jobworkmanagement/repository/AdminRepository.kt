package com.nilmani.jobworkmanagement.repository

import com.nilmani.jobworkmanagement.entity.Admin
import org.springframework.data.jpa.repository.JpaRepository

interface AdminRepository: JpaRepository<Admin,Long> {
}