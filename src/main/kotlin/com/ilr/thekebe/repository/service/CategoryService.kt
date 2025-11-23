package com.ilr.thekebe.repository.service

import com.ilr.thekebe.data.Category
import org.springframework.stereotype.Service

@Service
class CategoryService (private val categoryRepository: com.ilr.thekebe.repository.CategoryRepository) {
    fun getAllCategories() = categoryRepository.findAll()
    fun getCategoryById(id: Long) = categoryRepository.findById(id).orElse(null)
    fun saveCategory(category: Category) = categoryRepository.save(category)
    fun deleteCategory(id: Long) = categoryRepository.deleteById(id)
}