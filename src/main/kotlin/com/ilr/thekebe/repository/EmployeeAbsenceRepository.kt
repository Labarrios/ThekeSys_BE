package com.ilr.thekebe.repository

import com.ilr.thekebe.data.EmployeeAbsence
import org.springframework.data.repository.CrudRepository

interface EmployeeAbsenceRepository : CrudRepository<EmployeeAbsence, Long>