package com.nilmani.jobworkmanagement.controller

import com.nilmani.jobworkmanagement.model.request.ReqDeposit
import com.nilmani.jobworkmanagement.model.request.ReqUpdateDeposit
import com.nilmani.jobworkmanagement.model.request.ReqWithdrawMaterial
import com.nilmani.jobworkmanagement.model.response.ResMessage
import com.nilmani.jobworkmanagement.model.response.RespDeposit
import com.nilmani.jobworkmanagement.model.response.RespWithdrawMaterial
import com.nilmani.jobworkmanagement.repository.DepositRepository
import com.nilmani.jobworkmanagement.service.DepositService
import com.nilmani.jobworkmanagement.service.WithdrawMaterialService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin")
class AdminMaterialController {
    @Autowired
    private lateinit var materialService: WithdrawMaterialService
    @Autowired
    private lateinit var depositService: DepositService
    @Autowired
    private lateinit var depositRepository: DepositRepository


    @PostMapping("/withdraw")
    fun newWork(@ModelAttribute request:ReqWithdrawMaterial):ResponseEntity<*>{
        val newWork = materialService.withdraw(request)
        val respWork = RespWithdrawMaterial(
            newWork.userId,
            newWork.materialType,
            newWork.quantity,
            newWork.withdrawDate
        )
        return ResponseEntity(respWork,HttpStatus.OK)
    }
    @PostMapping("/deposit")
    fun acceptMaterial(@ModelAttribute request:ReqDeposit):ResponseEntity<*>{
        val receive = depositService.deposit(request)
        val respDeposit = RespDeposit(
            receive.userId,
            receive.totalPieces,
            receive.deposit,
            receive.pending
        )
        return ResponseEntity(respDeposit,HttpStatus.OK)
    }
    @PatchMapping("/verifyWorkstatus")
    fun updateMaterial(@ModelAttribute request: ReqUpdateDeposit):ResponseEntity<*>{
        val existingID = depositRepository.existsById(request.id)
        return if (existingID.equals(0)){
            if (request.pending.equals(0)){
                depositRepository.updateWorkStatus(true,request.id)
                ResponseEntity(ResMessage("Update Successfull"),HttpStatus.OK)
            }else{
                ResponseEntity(ResMessage("Still Some material pending near you "),HttpStatus.CHECKPOINT)
            }
        }else{
            ResponseEntity(ResMessage("No such Id exist"),HttpStatus.BAD_REQUEST)
        }
    }
}