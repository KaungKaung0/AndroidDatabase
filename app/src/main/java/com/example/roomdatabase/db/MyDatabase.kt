package com.example.roomdatabase.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabase.db.dao.CustomerDao
import com.example.roomdatabase.db.entity.Customer

@Database(
    entities = [Customer::class],
    version = 1
)
abstract class MyDatabase: RoomDatabase() {
    abstract fun customerDao():CustomerDao

    companion object {
        @Volatile private var instance: MyDatabase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }
        private fun buildDatabase(context: Context) = Room.databaseBuilder(context.applicationContext,
            MyDatabase::class.java, "mydb.db"
        ).build()
    }
}