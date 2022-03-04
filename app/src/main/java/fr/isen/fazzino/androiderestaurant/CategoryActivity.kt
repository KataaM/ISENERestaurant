package fr.isen.fazzino.androiderestaurant

import android.content.Intent
import android.os.Bundle
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

        val profileName=intent.getStringExtra(HomeActivity.CATEGORY_KEY)
        val categoryTitle = findViewById<TextView>(R.id.categoryTitle)
        categoryTitle.text = profileName;

        val recyclerView: RecyclerView = findViewById(R.id.categoryList)
        itemsList =resources.getStringArray(R.array.starter)

        customAdapter = CategoryAdapter(itemsList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager

        recyclerView.adapter = customAdapter
        customAdapter.setOnItemClickListener(object : CategoryAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                Toast.makeText(this@CategoryActivity, "You clicked on item : $position",Toast.LENGTH_SHORT ).show()
                goToDetailsView("test")
            }
        })
    }

    fun goToDetailsView(selectedCategory : String){
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(DETAILS_TITLE_KEY,selectedCategory)
        intent.putExtra(DETAILS_TITLE_PARA,"testPara")
        startActivity(intent)
    }

    companion object {
        const val DETAILS_TITLE_KEY = "detailsTitle"
        const val DETAILS_TITLE_PARA = "detailsParagraph"

    }



}