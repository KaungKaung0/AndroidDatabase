package com.example.roomdatabase.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customers")
data class Customer (
    @PrimaryKey(autoGenerate = true)
    var id:Int,

    @ColumnInfo(name = "name")
    var name:String?,

    @ColumnInfo(name = "email")
    var email:String?,

    @ColumnInfo(name = "phone_no")
    var phone_no: String?,

    @ColumnInfo(name = "address")
    var address: String?
)