package com.ilr.thekebe.repository

import com.ilr.thekebe.data.Vacation
import org.springframework.data.repository.CrudRepository

interface VacationRepository : CrudRepository<Vacation, Long>