package com.ilr.thekebe.data

import com.ilr.thekebe.enum.VacationStatus
import jakarta.persistence.Column
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.time.LocalDate

class Vacation (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    var vacationId: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    open var employee: Employee? = null,

    @Column(name = "start_date", columnDefinition = "DATE", nullable = false)
    var startDate: LocalDate? = null,

    @Column(name = "end_date", columnDefinition = "DATE", nullable = false)
    var endDate: LocalDate? = null,

    @Column(
        name = "days_taken",
        columnDefinition = "INT GENERATED ALWAYS AS ((end_date - start_date) + 1) STORED",
        nullable = false,
        insertable = false,
        updatable = false
    )
    var daysTaken: Int = 0,

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "vacation_status", nullable = false)
    var status: VacationStatus = VacationStatus.Requested
)