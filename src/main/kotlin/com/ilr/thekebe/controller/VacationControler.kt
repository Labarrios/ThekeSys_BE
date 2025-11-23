package com.ilr.thekebe.controller

import com.ilr.thekebe.data.Vacation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/employee/vacation")
class VacationControler {

    @PostMapping("/")
    fun requestVacation(
        @RequestParam employeeId: Long,
        @RequestParam startDate: String,
        @RequestParam endDate: String
    ): ResponseEntity<String> {
        // Logic to handle vacation request
        return ResponseEntity.ok("Vacation requested for Employee $employeeId from $startDate to $endDate.")
    }

    @PutMapping("/approve/{vacationId}")
    fun approveVacation(@PathVariable vacationId: Long): ResponseEntity<String> {
        // Logic to approve vacation request
        return ResponseEntity.ok("Vacation request $vacationId approved.")
    }

    @PutMapping("/reject/{vacationId}")
    fun rejectVacation(@PathVariable vacationId: Long): ResponseEntity<String> {
        // Logic to reject vacation request
        return ResponseEntity.ok("Vacation request $vacationId rejected.")
    }

    @GetMapping("/{employeeId}")
    fun getVacationStatus(@PathVariable employeeId: Long): ResponseEntity<List<Vacation>> {
        // Logic to retrieve vacation status for the employee
        val vacations = listOf<Vacation>() // Replace with actual retrieval logic
        return ResponseEntity.ok(vacations)
    }
}