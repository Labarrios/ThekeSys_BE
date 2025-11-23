package com.ilr.thekebe.repository

import com.ilr.thekebe.data.Category
import org.springframework.data.repository.CrudRepository

interface CategoryRepository : CrudRepository<Category, Long>