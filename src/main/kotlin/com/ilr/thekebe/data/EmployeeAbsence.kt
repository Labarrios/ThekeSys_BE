package com.ilr.thekebe.data

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "EmployeeAbsence")
class EmployeeAbsence (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "absence_id")
    var absenceId: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    open var employee: Employee? = null,

    @Column(name = "date", columnDefinition = "DATE")
    var date: LocalDate? = null,

    @Column(name = "justified")
    var justified: Boolean = false,

    @Column(name = "reason", length = 255)
    var reason: String? = null
)