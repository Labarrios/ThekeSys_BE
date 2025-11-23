package com.ilr.thekebe.repository

import com.ilr.thekebe.data.Customer
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<Customer, Long>