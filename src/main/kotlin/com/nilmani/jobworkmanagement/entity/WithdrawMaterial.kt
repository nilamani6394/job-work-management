package com.nilmani.jobworkmanagement.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class WithdrawMaterial(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "withdrawId")
    val id:Long=-1,
    val userId:Long=-1,
    val materialType:String="",
    val quantity:Long=-1,
    val withdrawDate:LocalDateTime= LocalDateTime.now()
)
