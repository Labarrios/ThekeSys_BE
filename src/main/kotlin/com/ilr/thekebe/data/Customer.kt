package com.ilr.thekebe.data

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "Customer")
class Customer (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    var customerId: Long? = null,

    @Column(name = "first_name", length = 100, nullable = false)
    var firstName: String = "",

    @Column(name = "last_name", length = 100, nullable = false)
    var lastName: String = "",

    @Column(name = "phone", length = 20)
    var phone: String? = null,

    @Column(name = "email", length = 100, unique = true)
    var email: String? = null,

    @Column(name = "address", length = 200)
    var address: String? = null,

    @Column(name = "registration_date", columnDefinition = "DATE DEFAULT CURRENT_DATE")
    var registrationDate: LocalDate? = null
)