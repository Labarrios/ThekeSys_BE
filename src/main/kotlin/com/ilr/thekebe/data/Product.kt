package com.ilr.thekebe.data

import com.ilr.thekebe.enum.ProductType
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
import java.time.LocalDate

@Entity
@Table(name = "Product")
class Product (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    var productId: Long? = null,

    @Column(name = "title", length = 200, nullable = false)
    var title: String = "",

    @Enumerated(EnumType.STRING)
    @Column(name = "product_type", columnDefinition = "product_type", nullable = false)
    var type: ProductType = ProductType.Book,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    open var category: Category? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_artist_id", nullable = false)
    open var authorArtist: AuthorArtist? = null,

    @Column(name = "price", nullable = false)
    var price: Double = 0.0,

    @Column(name = "cost", nullable = false)
    var cost: Double = 0.0,

    @Column(name = "description",columnDefinition = "text", nullable = true)
    var description: String? = null,

    @Column(name = "publication_date", columnDefinition = "DATE")
    var publicationDate: LocalDate? = null,

    @Column(name = "isbn_issn", length = 50, unique = true)
    var isbnIssn: String? = null
)