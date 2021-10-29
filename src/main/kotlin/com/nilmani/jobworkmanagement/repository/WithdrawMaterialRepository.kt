package com.nilmani.jobworkmanagement.repository

import com.nilmani.jobworkmanagement.entity.WithdrawMaterial
import org.springframework.data.jpa.repository.JpaRepository

interface WithdrawMaterialRepository :JpaRepository<WithdrawMaterial,Long> {
}