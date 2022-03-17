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

class CategoryAdapter(private val dataSet: Category) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private lateinit var myListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        myListener = listener
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View, listener: onItemClickListener) : RecyclerView.ViewHolder(view) {

        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val plateImage: AppCompatImageView = view.findViewById(R.id.plateImage)
        val priceTextView: TextView = view.findViewById(R.id.priceTextView)

        init {
            // Define click listener for the ViewHolder's View.

            view.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.category_cell, viewGroup, false)

        return ViewHolder(view, myListener)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        val dishPrompted = dataSet.items[position]


        viewHolder.titleTextView.text = dishPrompted.name_fr
        viewHolder.priceTextView.text = dishPrompted.prices[0].price.toString() + "€"
        val imageList = dishPrompted.images

        if (imageList.isNotEmpty() && imageList[0].isNotEmpty()) {
            Picasso.get().load(imageList[0]).fit().into(viewHolder.plateImage);
        }else {
            //Load an image random
            //TODO C DEGUEU GO FAIRE UN TRUC PROPRE
            Picasso.get().load("https://image.shutterstock.com/image-vector/picture-vector-icon-no-image-600w-1350441335.jpg").fit().into(viewHolder.plateImage);
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.items.size
}