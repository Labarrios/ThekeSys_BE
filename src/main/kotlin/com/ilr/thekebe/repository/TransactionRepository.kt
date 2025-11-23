package com.ilr.thekebe.repository

import com.ilr.thekebe.data.Transaction
import org.springframework.data.repository.CrudRepository

interface TransactionRepository : CrudRepository<Transaction, Long>