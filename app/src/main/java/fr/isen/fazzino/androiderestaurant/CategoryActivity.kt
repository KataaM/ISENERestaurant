package fr.isen.fazzino.androiderestaurant

import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.CategoryAdapter


class CategoryActivity: AppCompatActivity() {

    private lateinit var customAdapter: CategoryAdapter
    private lateinit var itemsList: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val profileName=intent.getStringExtra("selectedCategory")
        val categoryTitle = findViewById<TextView>(R.id.categoryTitle)
        categoryTitle.text = profileName;

        val recyclerView: RecyclerView = findViewById(R.id.dishRecyclerView)
        itemsList =resources.getStringArray(R.array.starter)

        customAdapter = CategoryAdapter(itemsList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager



        recyclerView.adapter = customAdapter
        customAdapter.setOnItemClickListener(object : CategoryAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(this@CategoryActivity, "You clicked on item : $position",Toast.LENGTH_SHORT ).show()
            }
        })

    }
}