package com.ilr.thekebe.repository.service

import com.ilr.thekebe.repository.EmployeeAbsenceRepository
import com.ilr.thekebe.data.EmployeeAbsence
import org.springframework.stereotype.Service

@Service
class EmployeeAbsence (private val repository: EmployeeAbsenceRepository) {
    fun getAllEmployeeAbsences() = repository.findAll()
    fun getEmployeeAbsenceById(id: Long) = repository.findById(id).orElse(null)
    fun saveEmployeeAbsence(employeeAbsence: EmployeeAbsence) = repository.save(employeeAbsence)
    fun deleteEmployeeAbsence(id: Long) = repository.deleteById(id)
}