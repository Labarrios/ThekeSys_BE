package com.ilr.thekebe.repository.service

import com.ilr.thekebe.data.TransactionDetail
import com.ilr.thekebe.repository.TransactionDetailRepository
import org.springframework.stereotype.Service

@Service
class TransactionDetailService (private val transactionDetailRepository: TransactionDetailRepository) {
    fun getAllTransactionDetails() = transactionDetailRepository.findAll()
    fun getTransactionDetailById(id: Long) = transactionDetailRepository.findById(id).orElse(null)
    fun saveTransactionDetail(transactionDetail: TransactionDetail) = transactionDetailRepository.save(transactionDetail)
    fun deleteTransactionDetail(id: Long) = transactionDetailRepository.deleteById(id)
}