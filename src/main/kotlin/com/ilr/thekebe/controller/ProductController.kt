package com.ilr.thekebe.controller

import com.ilr.thekebe.data.Inventory
import com.ilr.thekebe.data.Product
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/product")
class ProductController {

    @PostMapping("/")
    fun createProduct(@RequestBody product: Product): ResponseEntity<String> {
        // Here you would typically save the authorArtist to the database
        // For this example, we'll just return a success message
        return ResponseEntity.ok("Product created successfully")
    }

    @PutMapping("/")
    fun updateProduct(@RequestBody product: Product): ResponseEntity<String> {
        // Here you would typically update the authorArtist in the database
        // For this example, we'll just return a success message
        return ResponseEntity.ok("Product updated successfully")
    }

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Long): ResponseEntity<Product> {
        // Here you would typically retrieve the product from the database
        // For this example, we'll just return a dummy product
        val product = Product(id = id, name = "Sample Product", price = 9.99)
        return ResponseEntity.ok(product)
    }

    @GetMapping("/")
    fun getAllProducts(): ResponseEntity<List<Product>> {
        // Here you would typically retrieve all products from the database
        // For this example, we'll just return a list with a single dummy product
        val products = listOf(Product(id = 1, name = "Sample Product", price = 9.99))
        return ResponseEntity.ok(products)
    }

    @GetMapping("/inventary/{id}")
    fun getInventaryStatus(@PathVariable id: Long): ResponseEntity<Inventory> {
        // Here you would typically check the inventory status from the database
        // For this example, we'll just return a dummy status
        val inventory = Inventory(productId = id, quantityAvailable = 100)
        return ResponseEntity.ok(inventory)
    }

    @GetMapping("/inventary")
    fun getAllInventaryStatus(): ResponseEntity<List<Inventory>> {
        // Here you would typically retrieve all inventory statuses from the database
        // For this example, we'll just return a list with a single dummy status
        val inventories = listOf(Inventory(productId = 1, quantityAvailable = 100))
        return ResponseEntity.ok(inventories)
    }

}