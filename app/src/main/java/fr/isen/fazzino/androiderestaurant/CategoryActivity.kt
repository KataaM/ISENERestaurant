package fr.isen.fazzino.androiderestaurant

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.myapplication.CategoryAdapter
import com.google.gson.Gson
import fr.isen.fazzino.androiderestaurant.data.Category
import fr.isen.fazzino.androiderestaurant.data.DataDish
import fr.isen.fazzino.androiderestaurant.databinding.ActivityCategoryBinding
import org.json.JSONObject


class CategoryActivity : AppCompatActivity(), Response.Listener<JSONObject> {

    private lateinit var binding: ActivityCategoryBinding

    private lateinit var customAdapter: CategoryAdapter
    private lateinit var itemsList: ArrayList<String>
    private var dataDish: DataDish? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fillDataDishObject()
    }

    fun goToDetailsView(selectedCategory: String) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(DETAILS_TITLE_KEY, selectedCategory)
        intent.putExtra(DETAILS_TITLE_PARA, "testPara")
        startActivity(intent)
    }

    companion object {
        const val DETAILS_TITLE_KEY = "detailsTitle"
        const val DETAILS_TITLE_PARA = "detailsParagraph"
    }

    private fun fillDataDishObject() {

        val url = "http://test.api.catering.bluecodegames.com/menu"
        val ahOBJ = JSONObject()
        ahOBJ.put("id_shop", "1")
        Log.d("GFO", "kotJson")
        val queu = Volley.newRequestQueue(this)
        val ahReq = JsonObjectRequest(Request.Method.POST, url, ahOBJ,

            this, { error ->
                Log.d("GFO", "response: ${error.message}")
            })
        queu.add(ahReq)
    }

    override fun onResponse(response: JSONObject?) {

        var categoryName = intent.getStringExtra(HomeActivity.CATEGORY_KEY)
        binding.categoryTitle.text = categoryName

        //TODO C DE LA MREDE
        categoryName = "Entrées"
        //END TODO


        val str = response.toString()
        Log.d("GFO", "response: $str")

        val gson = Gson()
        dataDish = gson.fromJson(str, DataDish::class.java)

        //itemsList =resources.getStringArray(R.array.starter)

        Log.d("test", dataDish.toString())

        val category: Category? =
            dataDish?.data?.find { categoryData -> categoryData.name_fr == categoryName }

        if (category != null) {
            val customAdapter = category?.let { CategoryAdapter(it) }
            val layoutManager = LinearLayoutManager(applicationContext)
            binding.categoryList.layoutManager = layoutManager
            binding.categoryList.adapter = customAdapter

            customAdapter?.setOnItemClickListener(object : CategoryAdapter.onItemClickListener {
                override fun onItemClick(position: Int) {

                    Toast.makeText(
                        this@CategoryActivity,
                        "You clicked on item : $position",
                        Toast.LENGTH_SHORT
                    ).show()
                    goToDetailsView("test")
                }
            })
        }


    }
}

