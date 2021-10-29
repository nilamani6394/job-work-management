package com.nilmani.jobworkmanagement.model.request

data class ReqDeposit(
    val userId: Long = -1,
    val totalPieces: Long = -1,
    val deposit: Long = -1,
    val pending: Long = -1,
)
