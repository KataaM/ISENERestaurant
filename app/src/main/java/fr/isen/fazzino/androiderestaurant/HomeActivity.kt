package fr.isen.fazzino.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import fr.isen.fazzino.androiderestaurant.data.DataDish
import fr.isen.fazzino.androiderestaurant.databinding.ActivityHomeBinding
import org.json.JSONObject

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //fillDataDishObject()

        initButtons()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("HomeActivity", "destruction HomeActivity")
    }

    fun initButtons() {

        binding.buttonStarter.setOnClickListener {
            goToCategory("starter")
            //finish()
            //Log.d("test","testLog");
        }

        binding.buttonMainCourse.setOnClickListener {
            goToCategory("mainCourse")
            //finish()
        }

        binding.buttonDessert.setOnClickListener {
            goToCategory("dessert")
            //finish()
        }
    }

    fun goToCategory(selectedCategory: String) {
        //Toast.makeText(this@HomeActivity, "you clicked on starter dish", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, CategoryActivity::class.java)
        intent.putExtra(CATEGORY_KEY, selectedCategory)
        startActivity(intent)
    }

    companion object {
        const val CATEGORY_KEY = "selectedCategory"
    }


}