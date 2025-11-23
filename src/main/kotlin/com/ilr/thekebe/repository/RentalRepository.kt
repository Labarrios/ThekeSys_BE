package com.ilr.thekebe.repository

import com.ilr.thekebe.data.Rental
import org.springframework.data.repository.CrudRepository

interface RentalRepository : CrudRepository<Rental, Long>