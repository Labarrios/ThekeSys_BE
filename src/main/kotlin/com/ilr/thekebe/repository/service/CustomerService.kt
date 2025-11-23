package com.ilr.thekebe.repository.service

import com.ilr.thekebe.data.Customer
import org.springframework.stereotype.Service

@Service
class CustomerService (private val customerRepository: com.ilr.thekebe.repository.CustomerRepository) {
    fun findAll() = customerRepository.findAll()
    fun findById(id: Long) = customerRepository.findById(id).orElse(null)
    fun save(customer: Customer) = customerRepository.save(customer)
    fun deleteById(id: Long) = customerRepository.deleteById(id)
}