package com.meruga.networkconnection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val networkConnection = NetworkConnection(this)
        networkConnection.observe(this, Observer { isConnected ->
            val textView:TextView = findViewById(R.id.textView)
            textView.text = "Has Network? -  $isConnected"
            connectivityMonitor(isConnected)
        })
    }

    private fun connectivityMonitor(isNetworkAvailable : Boolean) {
        Toast.makeText(this, "Has Network? -  $isNetworkAvailable", Toast.LENGTH_SHORT).show()
    }
}