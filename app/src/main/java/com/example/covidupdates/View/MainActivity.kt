package com.example.covidupdates.View

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.covidupdates.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model = ViewModelProvider(this)[CovidViewModel::class.java]

        val totalConfirmed: TextView = findViewById(R.id.tconfirmed)
        val totalRecovered: TextView = findViewById(R.id.trecovered)
        val totalDeaths: TextView = findViewById(R.id.tdeaths)
        model.getCovidDetails()
        model.activeNo().observe(this, Observer {
            totalConfirmed.text = it.toString()
        })
        model.recoveredNo().observe(this, Observer {
            totalRecovered.text = it.toString()
        })
        model.deathsNo().observe(this, Observer {
            totalDeaths.text = it.toString()
        })
    }
}

