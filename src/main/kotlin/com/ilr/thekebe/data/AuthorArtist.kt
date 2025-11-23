package com.ilr.thekebe.data

import com.ilr.thekebe.enum.AuthorArtistType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "AuthorArtist")
class AuthorArtist(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_artist_id")
    var authorArtistId: Long? = null,

    @Column(name = "name", length = 100, nullable = false)
    var name: String = "",

    @Enumerated(EnumType.STRING)
    @Column(name = "author_artist_type", columnDefinition = "author_artist_type", nullable = false)
    var type: AuthorArtistType = AuthorArtistType.Author

)