package com.ilr.thekebe.repository

import com.ilr.thekebe.data.AttendanceRegistry
import org.springframework.data.repository.CrudRepository

interface AttendanceRegistryRepository : CrudRepository<AttendanceRegistry, Long>