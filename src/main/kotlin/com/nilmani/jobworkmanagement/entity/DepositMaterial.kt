package com.nilmani.jobworkmanagement.entity

import javax.persistence.*

@Entity
data class DepositMaterial(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "depositId")
    val id: Long = -1,
    val userId: Long = -1,
    val totalPieces: Long = -1,
    val deposit: Long = -1,
    val pending: Long = totalPieces-deposit,
    val workStatus: Boolean = false

)
