package com.ilr.thekebe.repository.service

import com.ilr.thekebe.data.Employee
import com.ilr.thekebe.repository.EmployeeRepository
import org.springframework.stereotype.Service

@Service
class EmployeeSerivice (private val employeeRepository: EmployeeRepository) {
    fun getAllEmployees() = employeeRepository.findAll()
    fun getEmployeeById(id: Long) = employeeRepository.findById(id).orElse(null)
    fun saveEmployee(employee: Employee) = employeeRepository.save(employee)
    fun deleteEmployee(id: Long) = employeeRepository.deleteById(id)
}