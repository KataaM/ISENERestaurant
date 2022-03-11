package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.isen.fazzino.androiderestaurant.R
import fr.isen.fazzino.androiderestaurant.data.Category
import fr.isen.fazzino.androiderestaurant.data.DataDish

class CategoryAdapter(private val dataSet:Category) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private lateinit var myListener : onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener : onItemClickListener){
        myListener = listener
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View,listener: onItemClickListener) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.itemTextView)

            textView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.category_cell, viewGroup, false)

        return ViewHolder(view,myListener)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = dataSet.items.get(position).name_fr
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.items.size
}