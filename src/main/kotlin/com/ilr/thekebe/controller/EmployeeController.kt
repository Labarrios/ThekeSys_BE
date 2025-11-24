package com.ilr.thekebe.controller

import com.ilr.thekebe.data.Employee
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/employee")
class EmployeeController {

    @PostMapping("/")
    fun createEmployee(@RequestBody employee: Employee): ResponseEntity<String> {
        // Here you would typically save the employee to the database
        // For this example, we'll just return a success message
        return ResponseEntity.ok("Employee created successfully")
    }

    @PutMapping("/")
    fun updateEmployee(@RequestBody employee: Employee): ResponseEntity<String> {
        // Here you would typically update the employee in the database
        // For this example, we'll just return a success message
        return ResponseEntity.ok("Employee updated successfully")
    }

    @DeleteMapping("/{id}")
    fun deleteEmployee(id: Long): ResponseEntity<String> {
        // Here you would typically mark the employee as inactive in the database
        // For this example, we'll just return a success message
        return ResponseEntity.ok("Employee with id $id deleted successfully")
    }

    @GetMapping("/{id}")
    fun getEmployeeById(id: Long): ResponseEntity<Employee> {
        // Here you would typically retrieve the employee from the database
        // For this example, we'll just return a dummy employee
        val employee = Employee(id = id, name = "John Doe", position = "Developer")
        return ResponseEntity.ok(employee)
    }

    @GetMapping("/")
    fun getAllEmployees(): ResponseEntity<List<Employee>> {
        // Here you would typically retrieve all employees from the database
        // For this example, we'll just return a list with a single dummy employee
        val employees = listOf(Employee(id = 1, name = "John Doe", position = "Developer"))
        return ResponseEntity.ok(employees)
    }


}