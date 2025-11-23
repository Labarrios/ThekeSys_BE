package com.ilr.thekebe.repository.service

import com.ilr.thekebe.data.Inventory
import com.ilr.thekebe.repository.InventoryRepository
import org.springframework.stereotype.Service

@Service
class InventoryService (private val inventoryRepository: InventoryRepository) {
    fun getAllInventories() = inventoryRepository.findAll()
    fun getInventoryById(id: Long) = inventoryRepository.findById(id).orElse(null)
    fun saveInventory(inventory: Inventory) = inventoryRepository.save(inventory)
    fun deleteInventory(id: Long) = inventoryRepository.deleteById(id)
}