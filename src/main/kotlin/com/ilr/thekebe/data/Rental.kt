package com.ilr.thekebe.data

import com.ilr.thekebe.enum.RentalStatus
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "Rental")
class Rental (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    var rentalId: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transaction_id", nullable = false)
    open var transaction: Transaction? = null,

    @Column(name = "start_date", columnDefinition = "DATE", nullable = false)
    var startDate: java.time.LocalDate? = null,

    @Column(name = "end_date", columnDefinition = "DATE", nullable = false)
    var endDate: java.time.LocalDate? = null,

    @Column(name = "return_date", columnDefinition = "DATE")
    var returnDate: java.time.LocalDate? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 50, nullable = false)
    var status: RentalStatus = RentalStatus.Rented

)