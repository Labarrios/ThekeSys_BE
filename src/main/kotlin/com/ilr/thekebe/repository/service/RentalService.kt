package com.ilr.thekebe.repository.service

import com.ilr.thekebe.data.Rental
import com.ilr.thekebe.repository.RentalRepository
import org.springframework.stereotype.Service

@Service
class RentalService (private val rentalRepository: RentalRepository) {
    fun getAllRentals() = rentalRepository.findAll()
    fun getRentalById(id: Long) = rentalRepository.findById(id).orElse(null)
    fun saveRental(rental: Rental) = rentalRepository.save(rental)
    fun deleteRental(id: Long) = rentalRepository.deleteById(id)
}