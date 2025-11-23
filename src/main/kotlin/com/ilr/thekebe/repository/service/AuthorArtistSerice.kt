package com.ilr.thekebe.repository.service

import com.ilr.thekebe.repository.AuthorArtistRepository
import org.springframework.stereotype.Service

@Service
class AuthorArtistSerice (private val AuthorArtistRepository: AuthorArtistRepository) {
    fun getAllAuthorArtists() = AuthorArtistRepository.findAll()
    fun getAuthorArtistById(id: Long) = AuthorArtistRepository.findById(id).orElse(null)
    fun saveAuthorArtist(authorArtist: com.ilr.thekebe.data.AuthorArtist) = AuthorArtistRepository.save(authorArtist)
    fun deleteAuthorArtist(id: Long) = AuthorArtistRepository.deleteById(id)
}