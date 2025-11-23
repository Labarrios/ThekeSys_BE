package com.ilr.thekebe.repository.service

import com.ilr.thekebe.repository.EmployeeRepository
import org.springframework.stereotype.Service

@Service
class EmployeeSerivice (private val employeeRepository: EmployeeRepository) {
    fun getAllEmployees() = employeeRepository.findAll()
    fun getEmployeeById(id: Long) = employeeRepository.findById(id).orElse(null)
    fun saveEmployee(employee: com.ilr.thekebe.data.Employee) = employeeRepository.save(employee)
    fun deleteEmployee(id: Long) = employeeRepository.deleteById(id)
}