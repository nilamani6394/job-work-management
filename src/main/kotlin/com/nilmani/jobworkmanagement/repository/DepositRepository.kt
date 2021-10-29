package com.nilmani.jobworkmanagement.repository

import com.nilmani.jobworkmanagement.entity.DepositMaterial
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.web.bind.annotation.RequestParam
import javax.persistence.Id
import javax.transaction.Transactional

interface DepositRepository : JpaRepository<DepositMaterial, Long> {
    @Query("select m.quantity from  WithdrawMaterial  as m where m.userId =:userId")
    fun findmaterialByUserId(@RequestParam("userId") userId: Long): Long

    @Transactional
    @Modifying
    @Query("update DepositMaterial m set m.workStatus =:workStatus where m.pending<=1  and m.userId=:userId")
    fun isPendingZero(@RequestParam("workStatus") workStatus: Boolean, userId: Long)

    /** find user by userID*/
    fun findByUserId(userId: Long):Long

    @Transactional
    @Modifying
    @Query("update DepositMaterial d set d.workStatus =:workStatus where d.id =:id")
    fun updateWorkStatus(@RequestParam("workStatus")workStatus: Boolean,id: Long)

//    @Transactional
//    @Modifying
//    @Query("update DepositMaterial m  set m.workStatus =:workStatus where m.id =: depositId")
//    fun workComplete(@RequestParam("workStatus")workStatus:Boolean, id:Long)
}

