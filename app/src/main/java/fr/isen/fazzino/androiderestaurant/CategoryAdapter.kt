package com.example.myapplication

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.isen.fazzino.androiderestaurant.R
import fr.isen.fazzino.androiderestaurant.data.Category
import fr.isen.fazzino.androiderestaurant.data.Dish

class CategoryAdapter(private val dataSet: List<Dish>, val mListener: (Dish) -> Unit) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val plateImage: AppCompatImageView = view.findViewById(R.id.dishImage)
        val priceTextView: TextView = view.findViewById(R.id.priceTextView)

    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.category_cell, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        val dishPrompted = dataSet[position]

        viewHolder.titleTextView.text = dishPrompted.name_fr
        viewHolder.priceTextView.text = dishPrompted.prices[0].price.toString() + "€"
        val imageList = dishPrompted.images

        if (imageList[0] != "" ) {
            Picasso.get().load(imageList[0]).error(R.drawable.not_found).fit().into(viewHolder.plateImage)
        }

        viewHolder.itemView.setOnClickListener{
            mListener(dishPrompted)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size
}