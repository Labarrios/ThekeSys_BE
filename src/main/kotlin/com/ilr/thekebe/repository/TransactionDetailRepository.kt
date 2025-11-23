package com.ilr.thekebe.repository

import com.ilr.thekebe.data.TransactionDetail
import org.springframework.data.repository.CrudRepository

interface TransactionDetailRepository : CrudRepository<TransactionDetail, Long>