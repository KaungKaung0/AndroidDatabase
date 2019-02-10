package com.example.roomdatabase.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomdatabase.db.entity.Customer

@Dao
interface CustomerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(customer: List<Customer>)

    @Query("SELECT * FROM customers")
    fun getAll(): List<Customer>

    @Query("SELECT * FROM customers WHERE id =:id")
    fun getCustomerById(id: Int): Customer
}