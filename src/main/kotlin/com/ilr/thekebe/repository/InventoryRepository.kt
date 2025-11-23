package com.ilr.thekebe.repository

import com.ilr.thekebe.data.Inventory
import org.springframework.data.repository.CrudRepository

interface InventoryRepository : CrudRepository<Inventory, Long>