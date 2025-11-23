package com.ilr.thekebe.repository

import com.ilr.thekebe.data.Product
import org.springframework.data.repository.CrudRepository

interface ProductRepository : CrudRepository<Product, Long>