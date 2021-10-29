package com.nilmani.jobworkmanagement.service

import com.nilmani.jobworkmanagement.entity.DepositMaterial
import com.nilmani.jobworkmanagement.model.request.ReqDeposit
import com.nilmani.jobworkmanagement.model.request.ReqUpdateDeposit
import com.nilmani.jobworkmanagement.repository.DepositRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DepositService {
    @Autowired
    private lateinit var depositRepository: DepositRepository

    fun deposit(request:ReqDeposit):DepositMaterial{
        val acceptMaterial = DepositMaterial(
            userId = request.userId,
            totalPieces = depositRepository.findmaterialByUserId(request.userId),
            deposit = request.deposit,
        )
        return depositRepository.save(acceptMaterial)
    }
    /**Now update the material table*/

    fun updateWorkStatus(request:ReqUpdateDeposit):DepositMaterial{
        val existId = depositRepository.findById(request.id)
     if (existId != null){
          if (request.pending.equals(0)){
              depositRepository.updateWorkStatus(true,request.id)
          }else{
              println("Still some material pending near you..........")
          }
      }else{
          println("NO this is not a valid id")
      }
     return DepositMaterial()
    }

}