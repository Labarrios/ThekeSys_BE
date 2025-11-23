package com.ilr.thekebe.repository.service

import com.ilr.thekebe.data.Rental
import com.ilr.thekebe.data.Transaction
import com.ilr.thekebe.data.TransactionDetail
import com.ilr.thekebe.data.request.TransactionRequest
import com.ilr.thekebe.enum.TransactionType
import com.ilr.thekebe.repository.RentalRepository
import com.ilr.thekebe.repository.TransactionDetailRepository
import com.ilr.thekebe.repository.TransactionRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class TransactionService (private val transactionRepository: TransactionRepository,
                          private val transactionDetailRepository: TransactionDetailRepository,
                          private val RentalRepository: RentalRepository) {
    fun getAllTransactions() = transactionRepository.findAll()
    fun getTransactionById(id: Long) = transactionRepository.findById(id).orElse(null)
    fun saveTransaction(transaction: Transaction) = transactionRepository.save(transaction)
    fun deleteTransaction(id: Long) = transactionRepository.deleteById(id)

    @Transactional
    fun saveSale(request: TransactionRequest): String {

            val tx = Transaction()
            tx.type = TransactionType.Sale
            tx.date = request.date
            tx.totalAmount = request.totalAmount
            tx.customer?.customerId = request.customerId
            tx.employee?.employeeId = request.employeeId

            val savedTx = transactionRepository.save(tx)

            val details = request.details.map { d ->
                val txDetail = TransactionDetail()
                txDetail.transaction = savedTx
                txDetail.product?.productId = d.productId
                txDetail.quantity = d.quantity
                txDetail.unitPrice = d.unitPrice
                txDetail
            }

            transactionDetailRepository.saveAll(details)

            return "CREATED"
    }

    @Transactional
    fun saveRental(request: TransactionRequest): String {

        val tx = Transaction()
        tx.type = TransactionType.Rental
        tx.date = request.date
        tx.totalAmount = request.totalAmount
        tx.customer?.customerId = request.customerId
        tx.employee?.employeeId = request.employeeId

        val savedTx = transactionRepository.save(tx)

        var rental = Rental()

        rental.transaction = savedTx
        rental.startDate = request.rental.startDate
        rental.returnDate = request.rental.returnDate
        rental.endDate = request.rental.endDate
        rental.status = request.rental.status

        RentalRepository.save(rental);

        val details = request.details.map { d ->
            val txDetail = TransactionDetail()
            txDetail.transaction = savedTx
            txDetail.product?.productId = d.productId
            txDetail.quantity = d.quantity
            txDetail.unitPrice = d.unitPrice
            txDetail
        }

        transactionDetailRepository.saveAll(details)

        return "CREATED"
    }

    @Transactional
    fun savePurchase(request: TransactionRequest): String {

        val tx = Transaction()
        tx.type = TransactionType.Purchase
        tx.date = request.date
        tx.totalAmount = request.totalAmount
        tx.customer?.customerId = request.customerId
        tx.employee?.employeeId = request.employeeId

        val savedTx = transactionRepository.save(tx)

        val details = request.details.map { d ->
            val txDetail = TransactionDetail()
            txDetail.transaction = savedTx
            txDetail.product?.productId = d.productId
            txDetail.quantity = d.quantity
            txDetail.unitPrice = d.unitPrice
            txDetail
        }

        transactionDetailRepository.saveAll(details)

        return "CREATED"
    }
}