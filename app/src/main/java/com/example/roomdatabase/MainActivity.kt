package com.example.roomdatabase

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import com.example.roomdatabase.db.MyDatabase
import com.example.roomdatabase.db.entity.Customer

import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync

class MainActivity : AppCompatActivity() {

    val customers: MutableList<Customer> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val db = MyDatabase.invoke(this)

        customers.add(Customer(0, "Aung Aung", "aung@gmail.com", "095083160", "Hledan"))

        fab.setOnClickListener { view ->
            doAsync {
                                db.customerDao().insert(customers)
                val customers = db.customerDao().getAll()

                    for (customer in customers) {
                        Log.d("MY_CUSTOMER", customer.name)
                    }

            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
