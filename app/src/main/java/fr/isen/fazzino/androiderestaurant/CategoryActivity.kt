package fr.isen.fazzino.androiderestaurant

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.myapplication.CategoryAdapter
import com.google.gson.Gson
import fr.isen.fazzino.androiderestaurant.data.DataDish
import fr.isen.fazzino.androiderestaurant.databinding.ActivityCategoryBinding
import org.json.JSONObject


class CategoryActivity : AppCompatActivity(), Response.Listener<JSONObject> {

    private lateinit var binding: ActivityCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.categoryList.layoutManager = LinearLayoutManager(this)
        binding.categoryList.adapter = CategoryAdapter(arrayListOf()) {}
        fillDataDishObject()
    }

    companion object {
        const val DATA_DISH_OBJECT_KEY = "dataDishObject"
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar,menu)
        return true
    }

    override fun onResponse(response: JSONObject?) {

        var categoryName = intent.getStringExtra(HomeActivity.CATEGORY_KEY)
        binding.categoryTitle.text = categoryName

        val dataDish = Gson().fromJson(response.toString(), DataDish::class.java)

        //  val dishName: Category? =
        //dataDish?.data?.find { categoryData -> categoryData.name_fr == categoryName }

        val dishName = dataDish.data.firstOrNull{it.name_fr == categoryName}?.items ?: arrayListOf()

        val categoryAdapter =CategoryAdapter(dishName){

            val intent = Intent(this@CategoryActivity, DetailsActivity::class.java)

            intent.putExtra(DATA_DISH_OBJECT_KEY,it)
            startActivity(intent)
        }

        binding.categoryList.adapter = categoryAdapter
    }
}

