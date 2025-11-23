package com.ilr.thekebe.data

import com.ilr.thekebe.enum.TransactionType
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

class Transaction (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    var transactionId: Long? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "type", columnDefinition = "transaction_type", nullable = false)
    var type: TransactionType = TransactionType.Sale,

    @Column(name = "date", columnDefinition = "DATE" , nullable = false)
    var date: LocalDate? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    open var customer: Customer? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    open var employee: Employee? = null,

    @Column(name = "total_amount", nullable = false)
    var totalAmount: Double = 0.0,

    @Column(name = "notes",columnDefinition = "text", nullable = true)
    var notes: String? = null,
)