package com.ilr.thekebe.controller

import com.ilr.thekebe.data.AuthorArtist
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/author")
class AuthorArtistController {

    @PostMapping("/")
    fun createAuthorArtist(@RequestBody authorArtist: AuthorArtist): ResponseEntity<String> {
        // Here you would typically save the authorArtist to the database
        // For this example, we'll just return a success message
        return ResponseEntity.ok("Author/Artist created successfully")
    }

    @PutMapping("/")
    fun updateAuthorArtist(@RequestBody authorArtist: AuthorArtist): ResponseEntity<String> {
        // Here you would typically update the authorArtist in the database
        // For this example, we'll just return a success message
        return ResponseEntity.ok("Author/Artist updated successfully")
    }

    @GetMapping("/{id}")
    fun getAuthorArtistById(@PathVariable id: Long): ResponseEntity<AuthorArtist> {
        // Here you would typically retrieve the authorArtist from the database
        // For this example, we'll just return a dummy authorArtist
        val authorArtist = AuthorArtist(id = id, name = "Dummy Name")
        return ResponseEntity.ok(authorArtist)
    }

    @GetMapping("/")
    fun getAllAuthorArtists(): ResponseEntity<List<AuthorArtist>> {
        // Here you would typically retrieve all authorArtists from the database
        // For this example, we'll just return a list with a single dummy authorArtist
        val authorArtists = listOf(AuthorArtist(id = 1, name = "Dummy Name"))
        return ResponseEntity.ok(authorArtists)
    }
}