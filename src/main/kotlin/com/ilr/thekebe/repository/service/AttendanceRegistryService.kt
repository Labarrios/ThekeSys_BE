package com.ilr.thekebe.repository.service

import com.ilr.thekebe.data.AttendanceRegistry
import com.ilr.thekebe.repository.AttendanceRegistryRepository
import org.springframework.stereotype.Service

@Service
class AttendanceRegistryService(private val attendanceRegistryRepository: AttendanceRegistryRepository) {
    fun getAllAttendanceRegistries() = attendanceRegistryRepository.findAll()
    fun getAttendanceRegistryById(id: Long) = attendanceRegistryRepository.findById(id).orElse(null)
    fun saveAttendanceRegistry(attendanceRegistry: AttendanceRegistry) = attendanceRegistryRepository.save(attendanceRegistry)
    fun deleteAttendanceRegistry(id: Long) = attendanceRegistryRepository.deleteById(id)
}