package com.ilr.thekebe.controller

import com.ilr.thekebe.data.request.TransactionRequest
import com.ilr.thekebe.repository.service.TransactionService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/transaction")
class TransactionController (private val transactionService: TransactionService) {

    @PostMapping("/sale")
    fun processSale(@RequestBody request: TransactionRequest): ResponseEntity<String> {
        val response = transactionService.saveSale(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }

    @PostMapping("/rental")
    fun processRental(@RequestBody request: TransactionRequest): ResponseEntity<String> {
        val response = transactionService.saveRental(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }

    @PostMapping("/purchase")
    fun processPurchase(@RequestBody request: TransactionRequest): ResponseEntity<String> {
        val response = transactionService.savePurchase(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }

    @PostMapping("/cancel/{id}")
    fun cancelTransaction(@RequestBody id: Long): ResponseEntity<String> {
        //val response = transactionService.cancelTransaction(id)
        return ResponseEntity.status(HttpStatus.OK).body("Cancelled")
    }
    


}