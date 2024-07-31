package com.example.cupcakeordermanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeMessageTextView: TextView = findViewById(R.id.home_message)
        homeMessageTextView.visibility = View.VISIBLE

        // Load the default fragment (OrderListFragment)
        if (savedInstanceState == null) {
            val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            val fragment = OrderListFragment()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val homeMessageTextView: TextView = findViewById(R.id.home_message)
        return when (item.itemId) {
            R.id.menu_view_orders -> {
                homeMessageTextView.visibility = View.GONE
                showOrderListFragment()
                true
            }
            R.id.menu_order_cake -> {
                homeMessageTextView.visibility = View.VISIBLE
                showOrderCakeDialog()
                true
            }
            R.id.menu_order_cupcakes -> {
                homeMessageTextView.visibility = View.VISIBLE
                showOrderCupcakesDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showOrderListFragment() {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = OrderListFragment()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

    private fun showOrderCakeDialog() {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        val dialog = OrderCakeDialogFragment()
        dialog.show(transaction, "order_cake_dialog")
    }

    private fun showOrderCupcakesDialog() {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        val dialog = OrderCupcakesDialogFragment()
        dialog.show(transaction, "order_cupcakes_dialog")
    }
}
