package fr.isen.fazzino.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initButtons()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("HomeActivity","destruction HomeActivity")
    }

    fun initButtons() {
        val btnStarter = findViewById<Button>(R.id.buttonStarter)
        btnStarter.setOnClickListener {
            goToCategory("starter")
            //finish()
            //Log.d("test","testLog");
        }

        val btnMainCourse = findViewById<Button>(R.id.buttonMainCourse)
        btnMainCourse.setOnClickListener {
            goToCategory("mainCourse")
            //finish()
        }

        val btnDessert = findViewById<Button>(R.id.buttonDessert)
        btnDessert.setOnClickListener {
            goToCategory("dessert")
            //finish()
        }
    }
    fun goToCategory(selectedCategory : String){
        //Toast.makeText(this@HomeActivity, "you clicked on starter dish", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, CategoryActivity::class.java)
        intent.putExtra(CATEGORY_KEY,selectedCategory)
        startActivity(intent)
    }

    companion object {
        const val CATEGORY_KEY = "selectedCategory"
    }
}