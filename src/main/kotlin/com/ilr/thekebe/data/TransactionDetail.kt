package com.ilr.thekebe.data

import jakarta.persistence.Column
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.math.BigDecimal

class TransactionDetail (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id")
    var DetailId: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transaction_id", nullable = false)
    open var transaction: Transaction? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    open var product: Product? = null,

    @Column(name = "quantity", nullable = false)
    var quantity: Int = 0,

    @Column(name = "unit_price", nullable = false)
    var unitPrice: Double = 0.0,

    @Column(
        name = "subtotal",
        columnDefinition = "numeric(10,2) GENERATED ALWAYS AS (quantity * unit_price) STORED",
        nullable = false,
        insertable = false,
        updatable = false
    )
    var subtotal: BigDecimal = BigDecimal.ZERO
)