package com.nilmani.jobworkmanagement.entity

import javax.persistence.*

@Entity
data class Admin(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="adminId")
    val id:Long=-1,
    val name:String="",
    @Column(unique = true)
    val email:String="",
    val password:String="",
    @Column(unique = true)
    val phoneNumber:String="",
    val otp:Int=0
)
