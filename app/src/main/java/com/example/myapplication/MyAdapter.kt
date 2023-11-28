package com.example.myapplication

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.*
import android.view.*
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.*

class MyAdapter(val list: List<Book>) : RecyclerView.Adapter<MyAdapter.MyView>() {

    class MyView(view: View) : RecyclerView.ViewHolder(view) {
        val bName: TextView = view.findViewById(R.id.bookName)
        val bYear: TextView = view.findViewById(R.id.bookYear)
        val bImage: ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
        return MyView(view)
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.bName.text = list.get(position).name
        holder.bYear.text = list.get(position).year
        Picasso.get().load(list.get(position).image).into(holder.bImage);
        holder.itemView.setOnClickListener {
            Snackbar.make(holder.itemView.rootView,"Test $position",Snackbar.LENGTH_LONG).show()
        }
    }
    override fun getItemCount() = list.size
}