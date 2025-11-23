package com.ilr.thekebe.repository.service

import com.ilr.thekebe.data.Product
import com.ilr.thekebe.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService (private val productRepository: ProductRepository) {
    fun findAll() = productRepository.findAll()
    fun findById(id: Long) = productRepository.findById(id).orElse(null)
    fun save(productData: Product) = productRepository.save(productData)
    fun deleteById(id: Long) = productRepository.deleteById(id)
}