package com.upn.movilapp3431.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.upn.movilapp3431.entities.Series

class SeriesListViewModel: ViewModel() {

    val series = mutableStateListOf<Series>()
    var isLoading by mutableStateOf(false)
    var hasError by mutableStateOf(false)

    private val database = Firebase.database
    private val seriesRef = database.getReference("series")

    init {
        loadSeries()
    }

    private fun loadSeries() {
        isLoading = true

        seriesRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val tempSeries = mutableListOf<Series>()
                for (item in dataSnapshot.children) {
                    Log.d("MAIN_APP", "Value is: $item")
                    val serie = item.getValue(Series::class.java)
                    tempSeries.add(serie!!)
                }

                series.clear()
                series.addAll(tempSeries)
                isLoading = false

                Log.d("MAIN_APP", "Series size: ${series.size}")
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("MAIN_APP", "Failed to read value.", error.toException())
                isLoading = false
                hasError = true
            }
        })
    }
}