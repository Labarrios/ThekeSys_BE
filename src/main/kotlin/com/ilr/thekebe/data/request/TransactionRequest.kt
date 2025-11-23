package com.ilr.thekebe.data.request

import com.ilr.thekebe.enum.TransactionType
import java.time.LocalDate

data class TransactionRequest(
    val customerId: Long,
    val employeeId: Long,
    val type: TransactionType = TransactionType.Sale,
    val date: LocalDate? = LocalDate.now(),
    val totalAmount: Double,
    val notes: String? = null,
    val rental: RentalRequest,
    val details: List<TransactionDetailRequest> = emptyList()
)