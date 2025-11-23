package com.ilr.thekebe.data.request

import com.ilr.thekebe.enum.RentalStatus
import java.time.LocalDate

class RentalRequest {
    val startDate: LocalDate? = LocalDate.now()
    val endDate: LocalDate? = LocalDate.now()
    val returnDate: LocalDate? = null
    val status: RentalStatus = RentalStatus.Rented
}