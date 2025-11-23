package com.ilr.thekebe.data.request

data class TransactionDetailRequest(
    val productId: Long,
    val quantity: Int,
    val unitPrice: Double
)