package com.ilr.thekebe.repository

import com.ilr.thekebe.data.Employee
import org.springframework.data.repository.CrudRepository

interface EmployeeRepository : CrudRepository<Employee, Long>