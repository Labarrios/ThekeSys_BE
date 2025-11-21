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
import java.time.LocalTime

@Entity
@Table(name = "AttendanceRegistry")
class AttendanceRegistry (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registry_id")
    var registryId: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    open var employee: Employee? = null,

    @Column(name = "date", columnDefinition = "DATE")
    var date: LocalDate? = null,

    @Column(name = "entry_time", columnDefinition = "TIME")
    var entryTime: LocalTime? = null,

    @Column(name = "exit_time", columnDefinition = "TIME")
    var exitTime: LocalTime? = null,

    @Column(name = "notes", length = 200)
    var notes: String? = null
)