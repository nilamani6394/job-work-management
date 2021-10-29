package com.nilmani.jobworkmanagement.entity

import javax.persistence.*

@Entity
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="userId")
    val id:Long=-1,
    val name:String=""
)
