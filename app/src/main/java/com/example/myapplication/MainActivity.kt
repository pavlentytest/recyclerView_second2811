package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder

data class Book(val name: String, val year: String, val image: String)
class MainActivity : AppCompatActivity() {

    private lateinit var books: List<Book>
    private lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById(R.id.recyclerView)
        val result = application.assets
            .open("books.json")
            .bufferedReader()
            .use { it.readText() }
        Log.d("RRR",result.toString())

        val gson = GsonBuilder().create()
        books = gson.fromJson(result,Array<Book>::class.java).toList()
        Log.d("RRR",books.toString())

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = MyAdapter(books)

    }
}