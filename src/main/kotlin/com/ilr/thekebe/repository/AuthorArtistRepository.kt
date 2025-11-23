package com.ilr.thekebe.repository

import com.ilr.thekebe.data.AuthorArtist
import org.springframework.data.repository.CrudRepository

interface AuthorArtistRepository : CrudRepository<AuthorArtist, Long>