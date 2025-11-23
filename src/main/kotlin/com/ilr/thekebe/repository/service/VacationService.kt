package com.ilr.thekebe.repository.service

import com.ilr.thekebe.repository.VacationRepository
import org.springframework.stereotype.Service

@Service
class VacationService (private val vacationRepository: VacationRepository ) {
    fun getAllVacations() = vacationRepository.findAll()
    fun getVacationById(id: Long) = vacationRepository.findById(id).orElse(null)
    fun saveVacation(vacation: com.ilr.thekebe.data.Vacation) = vacationRepository.save(vacation)
    fun deleteVacation(id: Long) = vacationRepository.deleteById(id)
}