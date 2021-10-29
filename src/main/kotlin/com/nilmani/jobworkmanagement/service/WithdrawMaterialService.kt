package com.nilmani.jobworkmanagement.service

import com.nilmani.jobworkmanagement.entity.WithdrawMaterial
import com.nilmani.jobworkmanagement.model.request.ReqWithdrawMaterial
import com.nilmani.jobworkmanagement.repository.UserRepository
import com.nilmani.jobworkmanagement.repository.WithdrawMaterialRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class WithdrawMaterialService {
    @Autowired
    private lateinit var withdrawRepository : WithdrawMaterialRepository
    @Autowired
    private lateinit var userRepository: UserRepository

    fun withdraw(request:ReqWithdrawMaterial):WithdrawMaterial{
//        val existUser =  userRepository.findById(request.userId)
//        if (!request.userId.equals(existUser)){
//            println("YOu are not a worker,To work register first")
//        }else{
            val newEntry = WithdrawMaterial(
                userId = request.userId,
                materialType = request.materialType,
                quantity = request.quantity,
                withdrawDate = LocalDateTime.now()
            )
            return withdrawRepository.save(newEntry)
//        }
//        return WithdrawMaterial()
    }
}